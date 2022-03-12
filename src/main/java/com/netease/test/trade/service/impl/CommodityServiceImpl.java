package com.netease.test.trade.service.impl;

import com.netease.test.trade.entity.Commodity;
import com.netease.test.trade.mapper.CommodityMapper;
import com.netease.test.trade.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public List<Commodity> getAllCommodity() {
        return commodityMapper.getAllCommodity();
    }

    @Override
    public Commodity getCommodityById(String id) {
        return commodityMapper.getCommodityById(id);
    }

    @Override
    public List<Commodity> getUnBuyCommodity() {
        return commodityMapper.getUnBuyCommodity();
    }

    @Override
    public void insertCommodity(Commodity commodity) {
        commodityMapper.insertCommodity(commodity);
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        commodityMapper.updateCommodity(commodity);
    }

    @Override
    public void deleteCommodity(String id) {
        commodityMapper.deleteCommodity(id);
    }


}
