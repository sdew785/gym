package com.ustb.gym.service;

import com.github.pagehelper.PageHelper;
import com.ustb.gym.mapper.PlaceMapper;
import com.ustb.gym.pojo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName： PlaceService
 * @Author: xumin
 * @Date: 2023/5/17 19:27
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@Service
public class PlaceService {
    @Autowired(required = false)
    PlaceMapper placeMapper;

    public List<Place> getPlace(String type) {
        return placeMapper.getPlace(type);
    }

    public List<Place> allPlace(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return placeMapper.allPlace();
    }

    public Integer placeSize() {
        List<Place> places = placeMapper.allPlace();
        return places.size();
    }

    public Place placeName(String name) {
        return placeMapper.placeName(name);
    }

    public Integer soSize(String key) {
        return placeMapper.so(key).size();
    }

    public List<Place> so(String key,
                          Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return placeMapper.so(key);
    }

    public void addPlace(Place place) {
        placeMapper.addPlace(place);
    }

    public void upPl(Place place) {
        placeMapper.upPl(place);
    }

    public Place pid(Integer pid){
        return placeMapper.pid(pid);
    }
}
