package com.example.app_demo.Models;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("img")
    private String img;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private String price;

    public Product(String id, String name, String img, String description, String price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String img, String description, String price) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
