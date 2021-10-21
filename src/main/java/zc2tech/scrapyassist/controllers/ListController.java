package zc2tech.scrapyassist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import zc2tech.scrapyassist.repo.SiteMongoRepository;
import zc2tech.scrapyassist.service.BeanFactoryDynamicAutowireService;

@Controller
@RequestMapping("/mongo/*")
public class ListController {
//    private final zc2tech.scrapyassist.service.SiteService SiteService;

//    public SiteController(SiteService SiteService) {
//        this.SiteService = SiteService;
//    }
    @Autowired
    private BeanFactoryDynamicAutowireService repoService;

    @GetMapping("/mongo/{shortUrlContext}")
    public String getAllSites(@PathVariable String shortUrlContext, Model model){
        MongoRepository repo = repoService.getRepo(shortUrlContext);
        model.addAttribute("listData", repo.findAll());

        // e.g. www-womenadvancenc-org
        return shortUrlContext;
    }
}
