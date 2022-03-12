package com.netease.test.trade.mapper;

import com.netease.test.trade.entity.CartItem;
import com.netease.test.trade.entity.PurItem;

import java.util.List;

public interface CartItemMapper {

    void addCartItem(CartItem cartItem);

    CartItem getCartItemById(String id);

    void updataCartItem(CartItem cartItem);

    List<CartItem> getAllCartItemVo();

    List<PurItem> getAllPurItemForSet();

    void deleteCartItemBatch(List<String> ids);
}
