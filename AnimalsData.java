package com.example.zooapp.AnimalsDetails;

public class AnimalsData {
    private String descA;
    private int imageA;
    private String namesA;
    private String spanA;
    private String specA;

    public AnimalsData(int imageA2, String namesA2, String specA2, String spanA2, String descA2) {
        this.imageA = imageA2;
        this.namesA = namesA2;
        this.specA = specA2;
        this.spanA = spanA2;
        this.descA = descA2;
    }

    public int getImageA() {
        return this.imageA;
    }

    public String getNamesA() {
        return this.namesA;
    }

    public String getSpecA() {
        return this.specA;
    }

    public String getSpanA() {
        return this.spanA;
    }

    public String getDescA() {
        return this.descA;
    }
}
