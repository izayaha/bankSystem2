package com.iza.service;

import com.iza.vo.VTradeInfo;

import java.util.Date;
import java.util.List;

public interface TradeService {
    public List<VTradeInfo> findAllTrade(Integer id, Date beginTime, Date endTime, Integer page, Integer limit);
    public void transfer(String code, String otherCode, Double money);
}
