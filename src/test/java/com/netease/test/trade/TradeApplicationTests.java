package com.netease.test.trade;

import com.netease.test.trade.entity.Account;
import com.netease.test.trade.entity.Commodity;
import com.netease.test.trade.mapper.AccountMapper;
import com.netease.test.trade.mapper.CommodityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TradeApplicationTests {

    @Autowired
    private CommodityMapper commodityMapper;

    @Test
    void contextLoads() {
        Commodity commodityById = commodityMapper.getCommodityById("1");
        System.out.println(commodityById);


    }

}
