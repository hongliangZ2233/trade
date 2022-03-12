package com.netease.test.trade.service;

import com.netease.test.trade.entity.PurItem;

import java.util.List;

public interface PurItemService {
    void purchase();

    List<PurItem> getAllPurItem();

    PurItem getPurItemById(String id);
}
