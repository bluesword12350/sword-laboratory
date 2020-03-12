package top.bluesword.web.laboratory.entity;

import javax.persistence.Id;

public class Poetry {

    private String title;

    @Id
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
