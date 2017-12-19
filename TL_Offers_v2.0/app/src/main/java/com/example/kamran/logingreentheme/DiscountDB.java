package com.example.kamran.logingreentheme;

/**
 * Created by Voutsas on 18/12/2017.
 */

public class DiscountDB {
    private String idoffer;
    private String productname;
    private String price;
    private String discount;
    private String description;
    private String photopath;
    private String idshop;



    public DiscountDB(String idoffer,String productname,String price,String discount,String description,String photopath,String idshop){
        this.idoffer = idoffer;
        this.productname = productname;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.photopath = photopath;
        this.idshop = idshop;
    }
    public String getIdoffer() {
        return idoffer;
    }

    public void setIdoffer(String idoffer) {
        this.idoffer = idoffer;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public String getIdshop() {
        return idshop;
    }

    public void setIdshop(String idshop) {
        this.idshop = idshop;
    }
}
