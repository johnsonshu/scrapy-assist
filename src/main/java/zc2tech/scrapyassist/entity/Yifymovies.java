package zc2tech.scrapyassist.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;

@Document(collection = "yifymovies")
public class Yifymovies extends CommonEnt {

    @Field("download_links")
    protected HashMap[] downloadLinks;

    @Field("subtitle_links")
    protected HashMap[] subtitleLinks;

    @Field("info_html")
    protected String infoHtml;

    @Field("cover_image_url")
    protected String coverImageUrl;

//    public Yifymovies(String id, String title, String article,String[] carouselImages, String[] imageUrls, ImageDownloadResult[] imageDlResults
//        ,HashMap[] downloadLinks,HashMap[] subtitleLinks,String coverImageUrl) {
//        super(id,title,article,carouselImages,imageUrls,imageDlResults);
//        this.downloadLinks = downloadLinks;
//        this.subtitleLinks = subtitleLinks;
//        this.coverImageUrl = coverImageUrl;
//    }

    public String getInfoHtml() {
        return infoHtml;
    }

    public HashMap[] getDownloadLinks() {
        return downloadLinks;
    }

    public HashMap[] getSubtitleLinks() {
        return subtitleLinks;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }
}
