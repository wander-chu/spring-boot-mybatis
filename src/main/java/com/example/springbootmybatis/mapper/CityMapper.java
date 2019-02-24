package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.City;
import com.example.springbootmybatis.utils.MyMapper;

/**
 * 城市Mapper
 */
public interface CityMapper extends MyMapper<City> {
    /**
     * 根据Id获取城市（包括省份信息）
     * 此方法旨在展示一对一的嵌套查询的方法（association）
     *
     * @param id 主键
     * @return City实体对象
     */
    City getCityById(Integer id);
}