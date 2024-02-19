package com.example.esraacofee.Domen;

import java.io.Serializable;

public class DomenDrink implements Serializable {

  private   String pic;
    private String title;
    private String extra;
    private Double fee;
    private  int numberInCard;

    public DomenDrink(String pic, String title, String extra, Double fee) {
        this.pic = pic;
        this.title = title;
        this.extra = extra;
        this.fee = fee;
    }

    public DomenDrink(String pic, String title, String extra, Double fee, int numberInCard) {
        this.pic = pic;
        this.title = title;
        this.extra = extra;
        this.fee = fee;
        this.numberInCard = numberInCard;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
