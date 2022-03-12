package com.netease.test.trade.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PurItem {
    private String id;
    private String title;
    private Date time;
    private int number;
    private double price;
    private String imageUrl;
}
