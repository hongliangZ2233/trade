package com.netease.test.trade.mapper;

import com.netease.test.trade.entity.Commodity;

import java.util.List;

public interface CommodityMapper {

    List<Commodity> getAllCommodity();

    Commodity getCommodityById(String id);

    List<Commodity> getUnBuyCommodity();

    void insertCommodity(Commodity commodity);

    void updateCommodity(Commodity commodity);

    void updateCommoditySellNum(Commodity commodity);

    void deleteCommodity(String id);

    List<Commodity> getCommodityByIds(List<String> ids);

}
