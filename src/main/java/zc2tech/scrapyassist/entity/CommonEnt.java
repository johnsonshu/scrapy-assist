package zc2tech.scrapyassist.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

public class CommonEnt {

    @Id
    protected String id;
    protected String title;
    protected String article;
    protected String[] imageUrls;
    @Field("image_dl_results")
    protected ImageDownloadResult[] imageDlResults;

    @Field("carousel_images")
    protected String[] carouselImages;

//    public CommonEnt(String id, String title, String article, String[] carouselImages, String[] imageUrls, ImageDownloadResult[] imageDlResults) {
//        this.id = id;
//        this.title = title;
//        this.article = article;
//        this.carouselImages = carouselImages;
//        this.imageUrls = imageUrls;
//        this.imageDlResults = imageDlResults;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageDownloadResult[] getImageDlResults() {
        return imageDlResults;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }
    
    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public String[] getCarouselImages() {
        return carouselImages;
    }
}
