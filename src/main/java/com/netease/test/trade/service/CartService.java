package com.netease.test.trade.service;

import com.netease.test.trade.entity.CartItem;

import java.util.List;

public interface CartService {
    void addCartItem(CartItem cartItem);

    CartItem getCartItemById(String id);

    void updateCartItemById(CartItem cartItem);

    List<CartItem> getAllCartItemVo();
}
