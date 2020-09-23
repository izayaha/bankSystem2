package com.iza.service.impl;

import com.iza.dao.BalanceDao;
import com.iza.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/9 22:14
 * description:
 */
@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    private BalanceDao balanceDao;

    @Override
    public Double findBalance(Integer id) {

        Double balance = balanceDao.findBalanceById(id);

        return balance;
    }
}
