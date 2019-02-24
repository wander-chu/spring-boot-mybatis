package com.example.springbootmybatis.model;

import java.util.List;

/**
 * 省份model
 */
public class Province extends BaseEntity {
    /**
     * 代码
     */
    private String provinceCode;

    /**
     * 名称
     */
    private String provinceName;

    /**
     * 城市列表
     */
    List<City> cities;

    /**
     * 获取代码
     *
     * @return provinceCode - 代码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置代码
     *
     * @param provinceCode 代码
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * 获取名称
     *
     * @return provinceName - 名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置名称
     *
     * @param provinceName 名称
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 获取城市列表
     *
     * @return cities - 城市列表
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * 设置城市列表
     *
     * @param cities 城市列表
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}