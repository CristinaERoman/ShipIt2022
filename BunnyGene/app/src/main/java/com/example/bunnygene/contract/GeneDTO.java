package com.example.bunnygene.contract;

public class GeneDTO {
    private String code;
    private String magnitude;
    private String repute;
    private String summary;

    public GeneDTO(String code, String magnitude, String repute, String summary) {
        this.code = code;
        this.magnitude = magnitude;
        this.repute = repute;
        this.summary = summary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getRepute() {
        return repute;
    }

    public void setRepute(String repute) {
        this.repute = repute;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
