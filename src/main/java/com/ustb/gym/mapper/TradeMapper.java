package com.ustb.gym.mapper;

import com.ustb.gym.pojo.Place;
import com.ustb.gym.pojo.Trade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xumin
 * @Date: 2023/05/19/18:25
 * @Description:
 */
public interface TradeMapper {
    List<Trade> allTrade();

    List<Trade> so(@Param("key") String key);

    //添加充值信息
    void addTrade(Trade trade);

}
