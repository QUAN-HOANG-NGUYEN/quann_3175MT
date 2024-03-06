package com.example.quann_3175mt;

public class Show {
    private String ShowName;
    private int ShowImage;
    private String ShowPrice;
    private int ShowRaw;

    public Show(String showName, int showImage, String showPrice, int showRaw) {
        ShowName = showName;
        ShowImage = showImage;
        ShowPrice = showPrice;
        ShowRaw = showRaw;
    }

    public String getShowName() {
        return ShowName;
    }

    public void setShowName(String showName) {
        ShowName = showName;
    }

    public int getShowImage() {
        return ShowImage;
    }

    public void setShowImage(int showImage) {
        ShowImage = showImage;
    }

    public String getShowPrice() {
        return ShowPrice;
    }

    public void setShowPrice(String showPrice) {
        ShowPrice = showPrice;
    }

    public int getShowRaw() {
        return ShowRaw;
    }

    public void setShowRaw(int showRaw) {
        ShowRaw = showRaw;
    }
}
