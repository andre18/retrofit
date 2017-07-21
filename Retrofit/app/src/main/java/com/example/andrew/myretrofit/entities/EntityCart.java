package com.example.andrew.myretrofit.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 08.04.2017.
 */

public class EntityCart {

    @SerializedName("user")
    @Expose
    private EntityUser entityUser;

    @SerializedName("entityFoodList")
    @Expose
    private List<EntityFood> entityFoodList;

    @SerializedName("integerListCount")
    @Expose
    private List<Integer> integerListCout;

    @SerializedName("entityOrderInfo")
    @Expose
    private EntityOrderInfo entityOrderInfo;

    public EntityCart() {
        entityFoodList = new ArrayList<>();
        integerListCout = new ArrayList<>();
        entityOrderInfo = new EntityOrderInfo(-1, "", "", "", "", null);
    }

    public EntityUser getEntityUser() {
        return entityUser;
    }

    public void addFood(EntityFood entityFood) {
        if (entityFoodList.contains(entityFood)) {
            int index = entityFoodList.indexOf(entityFood);
            Integer value = integerListCout.get(index);
            value += 1;
            integerListCout.set(index, value);
        } else {
            entityFoodList.add(entityFood);
            integerListCout.add(1);
        }
    }

    public void deleteOneFood(EntityFood entityFood) {
        if (entityFoodList.contains(entityFood)) {
            int index = entityFoodList.indexOf(entityFood);
            Integer value = integerListCout.get(index);
            if (value > 1) {
                value -= 1;
                integerListCout.set(index, value);
            } else {
                entityFoodList.remove(index);
                integerListCout.remove(index);
            }
        }
    }
}
