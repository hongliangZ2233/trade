package com.netease.test.trade.controller;

import com.netease.test.trade.entity.PurItem;
import com.netease.test.trade.service.PurItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PurItemController {
    @Autowired
    private PurItemService purItemService;

    @RequestMapping("/purchase")
    public String purchase(){
        purItemService.purchase();
        return "forward:/showCart";
    }

    @RequestMapping("/history")
    public String showHistory(HttpServletRequest request){
        List<PurItem> purItems= purItemService.getAllPurItem();
        request.setAttribute("purItems", purItems);
        int totalPrice = 0;
        for(PurItem item: purItems){
            totalPrice+= item.getPrice() * item.getNumber();
        }
        request.setAttribute("totalPrice", totalPrice);
        return "history";
    }



}
