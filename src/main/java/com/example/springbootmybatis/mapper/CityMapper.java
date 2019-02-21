package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.City;
import com.example.springbootmybatis.utils.MyMapper;

/**
 * 城市Mapper
 */
public interface CityMapper extends MyMapper<City> {
    /**
     *
     * @param id 主键
     * @return City实体对象
     */
    City getCityById(Integer id);
}