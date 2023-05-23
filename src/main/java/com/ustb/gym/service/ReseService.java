package com.ustb.gym.service;

import com.github.pagehelper.PageHelper;

import com.ustb.gym.mapper.PlaceMapper;
import com.ustb.gym.mapper.ReseMapper;
import com.ustb.gym.pojo.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName： ReseService
 * @Author: xumin
 * @Date: 2023/5/19 18:20
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@Service
public class ReseService {

    @Autowired(required = false)
    ReseMapper reseMapper;

    public List<Reserve> allRese(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return reseMapper.allRese();
    }

    public Integer reseSize() {
        return reseMapper.allRese().size();
    }

    public void addRese(Reserve reserve) {
        reseMapper.addRese(reserve);
    }

    public List<Reserve> so(String key,
                            Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return reseMapper.so(key);
    }

    public Integer soSize(String key) {
        return reseMapper.so(key).size();
    }
}
