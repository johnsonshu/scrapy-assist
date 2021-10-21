package zc2tech.scrapyassist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zc2tech.scrapyassist.repo.SiteMongoRepository;

@Controller
@RequestMapping("/sites")
public class SiteController {
//    private final zc2tech.scrapyassist.service.SiteService SiteService;

//    public SiteController(SiteService SiteService) {
//        this.SiteService = SiteService;
//    }
    @Autowired
    private SiteMongoRepository siteMongoRepository;

    @GetMapping
    public String getAllSites(Model model){
        model.addAttribute("sites", siteMongoRepository.findAll());

        return "sites";
    }
}
