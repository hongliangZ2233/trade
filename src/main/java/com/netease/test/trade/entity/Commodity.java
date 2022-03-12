package com.netease.test.trade.entity;


import lombok.Data;

@Data
public class Commodity {
    private String id;
    private String title;
    private String summary;
    private String detail;
    private String imageUrl;
    private double price;
    private int sellNum;

}
