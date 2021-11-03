package zc2tech.scrapyassist.controllers.ww;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zc2tech.scrapyassist.entity.WomenAdvanceNc;
import zc2tech.scrapyassist.entity.Yifymovies;
import zc2tech.scrapyassist.repo.WomenadvancencRepo;
import zc2tech.scrapyassist.repo.Ww1yifymoviesproRepo;
import zc2tech.scrapyassist.service.BeanFactoryDynamicAutowireService;

@Controller
public class Ww1yifymoviesproCon {
    @Autowired
    private Ww1yifymoviesproRepo repo;

    @GetMapping("/mongo/ww1-yifymovies-pro")
    public String getAllSites(Model model){
        model.addAttribute("listData", repo.findAll());
        return "ww/ww1-yifymovies-pro";
    }

    @GetMapping("/mongo-detail/ww1-yifymovies-pro")
    public String getAllSites(Model model,@RequestParam String docId){
        Yifymovies entity =  repo.findById(docId).get();
        model.addAttribute("detail", entity);

//        Document doc = Jsoup.parseBodyFragment(entity.getArticle());
//        Elements pngs = doc.select("img");
//
//        for (Element e:pngs) {
//            replaceElementAttr(e,"src",shortUrlContext, entity.getImageDlResults());
//            replaceElementAttr(e,"data-src",shortUrlContext, entity.getImageDlResults());
//        }
//        model.addAttribute("modifiedArticle", doc.body().html());

        // e.g. www-womenadvancenc-org
        return "ww/ww1-yifymovies-pro-detail";
    }
}
