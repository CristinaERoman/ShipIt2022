package com.example.bunnygene.contract;

public class RecommendationDTO {
    public String id;
    public String recommendation;
    public String description;
    public String icon;
    public String frequency;
    public String link;
    public String disease;
    public String gene;

    public RecommendationDTO() {};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getDisease() { return disease; }

    public void setDisease(String disease) { this.disease = disease; }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }
}
