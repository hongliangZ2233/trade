package com.netease.test.trade.entity.vo;

import lombok.Data;

@Data
public class CartItemVo{
    private String id;
    private int number;
    private double price;
    private String title;
}
