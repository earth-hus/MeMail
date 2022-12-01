package com.example.memail;

public class Saved {
    // Email draft
    private String Draft;

    // Email format
    private String UID;

    // Email title
    private String Title;

    // Constructors
    public Saved() {

    }

    public Saved(String Draft, String UID, String Title) {
        this.Draft = Draft;
        this.UID = UID;
        this.Title = Title;
    }

    // Getter methods

    public String getDraft() {
        return Draft;
    }

    public String getUID() {
        return UID;
    }

    public String getTitle() {
        return Title;
    }

    // Setter methods
    public void setDraft(String Draft) {
        this.Draft = Draft;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
}
