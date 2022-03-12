package com.netease.test.trade.controller;

import com.netease.test.trade.entity.CartItem;
import com.netease.test.trade.service.CartService;
import com.netease.test.trade.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/addToCart")
    public String addToCart(CartItem cartItem, HttpServletResponse response){
        CartItem cartItem1 = cartService.getCartItemById(cartItem.getId());
        if(cartItem1==null){
            cartService.addCartItem(cartItem);
        }else {
            cartItem.setNumber(cartItem.getNumber()+cartItem1.getNumber());
            cartService.updateCartItemById(cartItem);
        }
        return "redirect:/showCart";
    }

    @RequestMapping("/showCart")
    public String showCart(HttpServletRequest request){
        String referer = request.getHeader("Referer");
        String serverPort = String.valueOf(request.getServerPort());
        String[] split = referer.split("/");
        String fromUrl = "/"+split[split.length-1];
        if(fromUrl.endsWith(serverPort)){
            fromUrl = "/";
        }
        List<CartItem> cartItemList = cartService.getAllCartItemVo();
        request.setAttribute("cartItemList", cartItemList);
        request.setAttribute("fromUrl", fromUrl);
        return "cart";
    }






}
