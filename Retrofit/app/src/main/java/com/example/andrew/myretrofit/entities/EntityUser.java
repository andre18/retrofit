package com.example.andrew.myretrofit.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew on 03.04.2017.
 */

public class EntityUser {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("deviceId")
    @Expose
    private String deviceId;

    public EntityUser() {
    }

    public EntityUser(int id, String deviceId) {
        this.id = id;
        this.deviceId = deviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityUser that = (EntityUser) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
