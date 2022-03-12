package com.netease.test.trade.service.impl;

import com.netease.test.trade.entity.CartItem;
import com.netease.test.trade.mapper.CartItemMapper;
import com.netease.test.trade.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemMapper cartItemMapper;


    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemMapper.addCartItem(cartItem);
    }

    @Override
    public CartItem getCartItemById(String id) {
        return cartItemMapper.getCartItemById(id);
    }

    @Override
    public void updateCartItemById(CartItem cartItem) {
        cartItemMapper.updataCartItem(cartItem);
    }

    @Override
    public List<CartItem> getAllCartItemVo() {
        return cartItemMapper.getAllCartItemVo();
    }
}
