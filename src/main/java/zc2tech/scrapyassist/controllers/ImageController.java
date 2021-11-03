package zc2tech.scrapyassist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zc2tech.scrapyassist.service.BeanFactoryDynamicAutowireService;
import zc2tech.scrapyassist.utils.StringUtil;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping("/image/*/*")
public class ImageController {
//    private final zc2tech.scrapyassist.service.SiteService SiteService;

//    public SiteController(SiteService SiteService) {
//        this.SiteService = SiteService;
//    }
    @Autowired
    private BeanFactoryDynamicAutowireService repoService;

    @Value("${spring.file-image-path}")
    String fileImageParentPath;

    // TODO , how to control client browser cache ?
    @GetMapping("/image/{imgContext}/{imgFileName}")
    public ResponseEntity<byte[]>  showImage(@PathVariable String imgContext
            ,@PathVariable String imgFileName , Model model) throws Exception {

        String fullPath = fileImageParentPath + "/" + imgContext.substring(0,2) + "/" + imgContext + "/"
                + StringUtil.convertImageName2Path( imgFileName);

        String strType = Files.probeContentType(Path.of(fullPath));
        if (null == strType) {
            return null;
        }
        File f = new File(fullPath);
        if (f.exists()) {
            FileInputStream fis = new FileInputStream(f);
            var rtn = ResponseEntity.ok().contentType(MediaType.valueOf(strType)).body(fis.readAllBytes());
            fis.close();
            return rtn;
        }

        //Image image = getImageByName(fileName);
//        return ResponseEntity.ok().contentType(MediaType.valueOf(image.getFileType())).body(image.getData());
        return null;
    }
}
