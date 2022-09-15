package com.example.bunnygene.contract;

public class RecommendationDTO {
    public String id;
    public String title;
    public String description;
    public String image;
    public String frequency;
    public String link;

    public RecommendationDTO() {};

    public RecommendationDTO(String id, String title, String description, String image, String frequency, String link) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.frequency = frequency;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
