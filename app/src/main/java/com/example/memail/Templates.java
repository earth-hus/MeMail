package com.example.memail;

public class Templates {
    // Email category
    private String Category;

    // Email draft
    private String Draft;

    // Email format
    private String Format;

    // Email title
    private String Title;

    // Email topic
    private String Topic;

    // Constructors
    public Templates() {

    }

    public Templates(String Category, String Draft, String Format, String Title, String Topic) {
        this.Category = Category;
        this.Draft = Draft;
        this.Format = Format;
        this.Title = Title;
        this.Topic = Topic;
    }

    // Getter methods
    public String getCategory() {
        return Category;
    }

    public String getDraft() {
        return Draft;
    }

    public String getFormat() {
        return Format;
    }

    public String getTitle() {
        return Title;
    }

    public String getTopic() {
        return Topic;
    }

    // Setter methods
    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setDraft(String Draft) {
        this.Draft = Draft;
    }

    public void setFormat(String Format) {
        this.Format = Format;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setTopic(String Topic) {
        this.Topic = Topic;
    }
}
