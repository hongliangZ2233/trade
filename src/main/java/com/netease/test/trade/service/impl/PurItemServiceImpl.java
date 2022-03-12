package com.netease.test.trade.service.impl;

import com.netease.test.trade.entity.Commodity;
import com.netease.test.trade.entity.PurItem;
import com.netease.test.trade.mapper.CartItemMapper;
import com.netease.test.trade.mapper.CommodityMapper;
import com.netease.test.trade.mapper.PurItemMapper;
import com.netease.test.trade.service.PurItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PurItemServiceImpl implements PurItemService {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Autowired
    private PurItemMapper purItemMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    @Transactional
    public void purchase() {
        List<String> ids = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        List<PurItem> purItems = cartItemMapper.getAllPurItemForSet();
        for(PurItem item: purItems){
            item.setTime(new java.sql.Date(new Date().getTime()));
            ids.add(item.getId());
            map.put(item.getId(),item.getNumber());
        }
        purItemMapper.addPurItemBatch(purItems);
        cartItemMapper.deleteCartItemBatch(ids);
        List<Commodity> commoditys= commodityMapper.getCommodityByIds(ids);
        for(Commodity commodity: commoditys){
            commodity.setSellNum(commodity.getSellNum() + map.get(commodity.getId()));
            commodityMapper.updateCommoditySellNum(commodity);
        }


    }

    @Override
    public List<PurItem> getAllPurItem() {
        return purItemMapper.getAllPurItem();
    }

    @Override
    public PurItem getPurItemById(String id) {
        return purItemMapper.getPurItemById(id);
    }
}
