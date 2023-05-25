package com.ftn.sbnz.model;

public class PhotoConfiguration {
    private int ISO;
    private String aperture;
    private String shutterSpeed;

    public PhotoConfiguration(int ISO, String aperture, String shutterSpeed) {
        this.ISO = ISO;
        this.aperture = aperture;
        this.shutterSpeed = shutterSpeed;
    }

    public int getISO() {
        return ISO;
    }

    public void setISO(int ISO) {
        this.ISO = ISO;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }
}
