package zc2tech.scrapyassist.controllers;

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
import zc2tech.scrapyassist.entity.ImageDownloadResult;
import zc2tech.scrapyassist.entity.WomenAdvanceNc;
import zc2tech.scrapyassist.service.BeanFactoryDynamicAutowireService;
import zc2tech.scrapyassist.utils.StringUtil;

import java.util.List;

@Controller
@RequestMapping("/mongo-detail/*")
public class DetailController {
    @Autowired
    private BeanFactoryDynamicAutowireService repoService;

    @GetMapping("/mongo-detail/{shortUrlContext}")
    public String getDetail(@PathVariable String shortUrlContext, @RequestParam String docId, Model model){
        MongoRepository repo = repoService.getRepo(shortUrlContext);
        WomenAdvanceNc entity =  (WomenAdvanceNc)repo.findById(docId).get();
        model.addAttribute("detail", entity);

        Document doc = Jsoup.parseBodyFragment(entity.getArticle());
        Elements pngs = doc.select("img");

        for (Element e:pngs) {
            replaceElementAttr(e,"src",shortUrlContext, entity.getImageDlResults());
            replaceElementAttr(e,"data-src",shortUrlContext, entity.getImageDlResults());
        }
        model.addAttribute("modifiedArticle", doc.body().html());

        // e.g. www-womenadvancenc-org
        return shortUrlContext + "-detail";
    }

    /**
     *
     * @param e Parser Document Element
     * @param key Tag Attribute, for example: src data-src
     * @param shortUrlContext site name
     * @param dlResults image download results, there are url to download file path in it
     */
    private void replaceElementAttr(Element e,String key,String shortUrlContext, ImageDownloadResult[] dlResults) {
        String oldUrl = e.attr(key);
        String newUrl = null;
        newUrl = findLocalServerImgUrl(oldUrl,dlResults);
        if (null == newUrl) {
            // Maybe, it's "data:image" of a "src" attribute
            // In this condition, we always use "data-src" to find the image path
            // then replace the "src" attribute
            newUrl = findLocalServerImgUrl(e.attr("data-src"),dlResults);
        }

        if (null == newUrl) {
            // still no data
            e.attr(key,"#");
        } else {
            e.attr(key, "/image/" + shortUrlContext + "/"
                    + StringUtil.convertImagePath2Name(newUrl));
        }
    }

    private String findLocalServerImgUrl(String imgSrc, ImageDownloadResult[] dlResults) {
        for (ImageDownloadResult r : dlResults ) {
            if (r.getUrl().equals(imgSrc)) {
                return r.getPath();
            }
        }
        return null;
    }
}
