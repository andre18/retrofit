package com.example.andrew.myretrofit.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Andrew on 03.04.2017.
 */

public class EntityFood implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("category_id")
    @Expose
    private int categoryId;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("calories")
    @Expose
    private String kcal;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("weight")
    @Expose
    private String weight;

    @SerializedName("ingredients")
    @Expose
    private String ingredients;

    @SerializedName("imageLink")
    @Expose
    private String link;

    @SerializedName("rating")
    @Expose
    private String rating;

    public EntityFood() {
    }

    public EntityFood(int id, int categoryId, String title, String description,
                      String kcal, String price, String weight, String ingredients,
                      String link, String rating) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.kcal = kcal;
        this.price = price;
        this.weight = weight;
        this.ingredients = ingredients;
        this.link = link;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityFood that = (EntityFood) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "EntityFood{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", kcal='" + kcal + '\'' +
                ", price='" + price + '\'' +
                ", weight='" + weight + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", link='" + link + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
