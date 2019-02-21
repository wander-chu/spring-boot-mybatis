package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.Province;
import com.example.springbootmybatis.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 省份Mapper
 */
public interface ProvinceMapper extends MyMapper<Province> {
    /**
     * 返回第一条记录
     *
     * @return 第一个省份实体对象
     */
    @Select("select * from province limit 1")
    Province findOne();

    /**
     * 返回存在城市的省份列表
     *
     * @return
     */
    @Select("select * from province where exists (select 1 from city where city.p_id = province.id)")
    List<Province> findProvincesExistsCity();

    /**
     * 获取所有省份信息（包括包含的城市信息）
     * @return
     */
    List<Province> getAllProvinces();
}