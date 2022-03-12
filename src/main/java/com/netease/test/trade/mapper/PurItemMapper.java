package com.netease.test.trade.mapper;

import com.netease.test.trade.entity.PurItem;

import java.util.List;

public interface PurItemMapper {

    List<PurItem> getAllPurItem();

    void addPurItemBatch(List<PurItem> purItems);

    PurItem getPurItemById(String id);
}
