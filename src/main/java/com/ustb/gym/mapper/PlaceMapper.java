package com.ustb.gym.mapper;

import com.ustb.gym.pojo.Place;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xumin
 * @Date: 2023/05/17/19:21
 * @Description:
 */
public interface PlaceMapper {
    //按类型查询场地
    List<Place> getPlace(@Param("type") String type);

    //    查询场地
    List<Place> allPlace();

    //根据名字查场地
    Place placeName(@Param("name") String name);

    //模糊查询
    List<Place> so(@Param("key") String key);

    //添加Place信息
    void addPlace(Place place);

    void upPl(Place place);

    Place pid(@Param("pid") Integer pid);
}
