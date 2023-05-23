package com.ustb.gym.mapper;

import com.ustb.gym.pojo.Place;
import com.ustb.gym.pojo.Reserve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xumin
 * @Date: 2023/05/19/18:15
 * @Description:
 */
public interface ReseMapper {
    //查询预订信息
    List<Reserve> allRese();
    //添加预订信息
    void addRese(Reserve reserve);

    //模糊查询
    List<Reserve> so(@Param("key") String key);
}
