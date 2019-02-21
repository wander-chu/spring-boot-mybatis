package com.example.springbootmybatis.service;

import com.example.springbootmybatis.mapper.CityMapper;
import com.example.springbootmybatis.model.City;
import com.example.springbootmybatis.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市service
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    /**
     * 根据id获取城市信息
     *
     * @param id 主键
     * @return 城市实体对象
     */
    public City getCityById(Integer id) {
        return cityMapper.getCityById(id);
    }
}
