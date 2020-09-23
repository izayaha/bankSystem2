package com.iza.service.impl;

import com.github.pagehelper.PageHelper;
import com.iza.dao.TradeDao;
import com.iza.dao.UserDao;
import com.iza.entity.Trade;
import com.iza.entity.User;
import com.iza.service.TradeService;
import com.iza.vo.VTradeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/9 17:15
 * description:
 */
@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private UserDao userDao;
    @Override
    public List<VTradeInfo> findAllTrade(Integer id, Date beginTime, Date endTime, Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<VTradeInfo> list = tradeDao.findAll(id,beginTime,endTime);

        return list;
    }

    //业务层
    @Override
    public void transfer(String code, String otherCode, Double money) {
        //要被扣钱的人
        User loginUser = userDao.findByCode(code);
        //加钱的人
        User otherUser = userDao.findByCode(otherCode);
        if (otherUser == null) {
            throw new RuntimeException("用户不存在");
        }
        if (loginUser.getBankCode().equals(otherCode)) {
            throw new RuntimeException("不能给自己转钱");
        }
        if (loginUser.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }
        //当前用户减钱
        Trade outTrade = new Trade();
        outTrade.setUid(loginUser.getId());
        outTrade.setBalance(loginUser.getBalance() - money);
        outTrade.setMoney(0 - money);
        outTrade.setCreateTime(new Date());
        tradeDao.add(outTrade);

        loginUser.setBalance(loginUser.getBalance()-  money);
        userDao.update(loginUser);

        //另外一个账户加钱
        Trade inTrade = new Trade();
        inTrade.setUid(otherUser.getId());
        inTrade.setBalance(otherUser.getBalance() + money);
        inTrade.setMoney(money);
        inTrade.setCreateTime(new Date());
        tradeDao.add(inTrade);

        otherUser.setBalance(otherUser.getBalance() +  money);
        userDao.update(otherUser);


    }
}
