package com.iza.dao;

import com.iza.entity.Trade;
import com.iza.vo.VTradeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TradeDao {
    public List<VTradeInfo> findAll(@Param("uid") Integer uid,@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);
    public void add(Trade trade);
}
