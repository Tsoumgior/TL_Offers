package com.example.kamran.logingreentheme;

/**
 * Created by Voutsas on 1/12/2017.
 */

public class Shops {
    String idshop;
    String shopname;
    String category;
    String location;
    String number;

    public Shops(String idshop, String shopname, String category, String location, String number) {
        this.idshop = idshop;
        this.shopname = shopname;
        this.category = category;
        this.location = location;
        this.number = number;
    }

    public String getIdshop() {
        return idshop;
    }

    public String getShopname() {
        return shopname;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public String getNumber() {
        return number;
    }

    public Shops(){

    }
}
