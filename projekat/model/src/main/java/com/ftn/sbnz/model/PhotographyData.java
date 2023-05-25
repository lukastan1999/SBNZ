package com.ftn.sbnz.model;

public class PhotographyData {
    private String weatherCondition;
    private String depthOfField;
    private String subjectMovement;

    public PhotographyData(String weatherCondition, String depthOfField, String subjectMovement) {
        this.weatherCondition = weatherCondition;
        this.depthOfField = depthOfField;
        this.subjectMovement = subjectMovement;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getDepthOfField() {
        return depthOfField;
    }

    public void setDepthOfField(String depthOfField) {
        this.depthOfField = depthOfField;
    }

    public String getSubjectMovement() {
        return subjectMovement;
    }

    public void setSubjectMovement(String subjectMovement) {
        this.subjectMovement = subjectMovement;
    }
}
