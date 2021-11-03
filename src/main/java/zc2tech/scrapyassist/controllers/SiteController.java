package zc2tech.scrapyassist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import zc2tech.scrapyassist.entity.Site;
import zc2tech.scrapyassist.repo.SiteRepo;

@Controller
@RequestMapping("/sites/*")
public class SiteController {
//    private final zc2tech.scrapyassist.service.SiteService SiteService;

//    public SiteController(SiteService SiteService) {
//        this.SiteService = SiteService;
//    }
    @Autowired
    private SiteRepo siteRepo;

    @GetMapping("/sites/list")
    public String getAllSites(Model model){
        model.addAttribute("sites", siteRepo.findAll());

        return "sites/list";
    }

    @GetMapping("/sites/add")
    public String addSite(Model model){
        model.addAttribute("site",new Site());
        return "sites/add";
    }

    @RequestMapping(value = "/sites/do-add",method = RequestMethod.POST)
    public String doAddSite(Model model,@RequestBody MultiValueMap<String, String> f){
        Site s = new Site(f.getFirst("title"),f.getFirst("url"),f.getFirst("description"));
        siteRepo.insert(s);
        model.addAttribute("note","Site Added :" + f.getFirst( "title"));
        return getAllSites(model);
    }

    @GetMapping("/sites/do-del")
    public String doDelSite(Model model,@RequestParam("siteId") String siteId ){
        Site s = siteRepo.findById(siteId).get();
        siteRepo.deleteById(siteId);
        model.addAttribute("note","Site Deleted :" + s.getTitle());
        return getAllSites(model);
    }

    @PostMapping("/sites/do-search")
    public String doSearchSite(Model model,@RequestParam("keyword") String keyword ){
        if (null == keyword || keyword.trim().equals("")) {
            return getAllSites(model);
        }

        var result  = siteRepo.queryByKeyword(keyword);
        model.addAttribute("sites",result);
        return "sites/list";
    }
}
