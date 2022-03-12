package com.netease.test.trade.service;


import com.netease.test.trade.entity.Commodity;

import java.util.List;

public interface CommodityService {
    List<Commodity> getAllCommodity();

    Commodity getCommodityById(String id);

    List<Commodity> getUnBuyCommodity();

    void insertCommodity(Commodity commodity);

    void updateCommodity(Commodity commodity);

    void deleteCommodity(String id);


}
