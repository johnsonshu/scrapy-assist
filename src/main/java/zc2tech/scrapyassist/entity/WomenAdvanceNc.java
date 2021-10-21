package zc2tech.scrapyassist.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "womenadvancenc")
public class WomenAdvanceNc {

    @Id
    private String id;
    private String title;
    private String article;
    private String[] imageUrls;
    @Field("image_dl_results")
    private ImageDownloadResult[] imageDlResults;

    public WomenAdvanceNc(String id, String title, String article, String[] imageUrls, ImageDownloadResult[] imageDlResults) {
        this.id = id;
        this.title = title;
        this.article = article;
        this.imageUrls = imageUrls;
        this.imageDlResults = imageDlResults;
    }

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
}
