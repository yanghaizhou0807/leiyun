package com.example.admin.leiyun_ic.MyMall.entity;

import java.io.Serializable;

public class RecordEntity implements Serializable {
    public String time;//时间
    public String name;//名称
    public String price;//价格


    public RecordEntity() {
    }

    public RecordEntity(String time, String name, String price) {
        this.time = time;
        this.name = name;
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String imgPath) {
        this.time = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String goodsName) {
        this.name = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String goodsPrice) {
        this.price = goodsPrice;
    }


    @Override
    public String toString() {
        return "RecordEntity{" +
                "imgPath='" + time + '\'' +
                ", goodsName='" + name + '\'' +
                ", goodsPrice='" + price + '\'' +
                '}';
    }
}
