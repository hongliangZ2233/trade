package com.netease.test.trade.service.impl;

import com.netease.test.trade.entity.Account;
import com.netease.test.trade.mapper.AccountMapper;
import com.netease.test.trade.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean validUser(String userName, String password) {
        Account account = accountMapper.getAccountByName(userName);
        if(account==null){
            return false;
        }else if(!account.getPassword().equalsIgnoreCase(password)) {
            return false;
        }
        return true;
    }
}
