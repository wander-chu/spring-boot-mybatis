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
     * 返回存在城市的省份列表
     * 此方法旨在展示MyBatis注解的使用方法
     * 推荐使用Xml配置，所以此处不做过多、深入介绍
     *
     * @return
     */
    @Select("select * from province where exists (select 1 from city where city.p_id = province.id)")
    List<Province> getProvincesExistsCity();

    /**
     * 获取所有省份信息（包括包含的城市信息）
     * 此方法旨在展示一对多的嵌套查询的方法（collection）
     * @return
     */
    List<Province> getAllProvinces();
}