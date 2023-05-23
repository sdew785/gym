package com.ustb.gym.service;

import com.github.pagehelper.PageHelper;
import com.ustb.gym.mapper.ReseMapper;
import com.ustb.gym.mapper.TradeMapper;
import com.ustb.gym.pojo.Reserve;
import com.ustb.gym.pojo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName： TradeService
 * @Author: xumin
 * @Date: 2023/5/19 18:28
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@Service
public class TradeService {
    @Autowired(required = false)
    TradeMapper tradeMapper;

    public List<Trade> allTrade(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tradeMapper.allTrade();
    }
    public Integer reseSize(){
        return tradeMapper.allTrade().size();
    }
    public List<Trade> so(String key,
                          Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tradeMapper.so(key);
    }
    public Integer soize(String key){
        return tradeMapper.so(key).size();
    }

    public void addTrade(Trade trade){
        tradeMapper.addTrade(trade);
    }
}
