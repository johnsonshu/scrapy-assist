package zc2tech.scrapyassist.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sites")
public class Site {
    @Id
    private String id;
    private String title;
    private String url;
    private String description;

    public Site(String title, String url, String description) {
        this.title = title;
        this.url = url;
        this.description = description;
    }

    public Site() {
        this.title = "";
        this.url = "";
        this.description = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
