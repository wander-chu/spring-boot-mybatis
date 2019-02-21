package com.example.springbootmybatis.model;

import java.util.List;

/**
 * 省份model
 */
public class Province extends BaseEntity {
    /**
     * 代码
     */
    private String provincecode;

    /**
     * 名称
     */
    private String provincename;

    /**
     * 城市列表
     */
    List<City> cities;

    /**
     * 获取代码
     *
     * @return provincecode - 代码
     */
    public String getProvincecode() {
        return provincecode;
    }

    /**
     * 设置代码
     *
     * @param provincecode 代码
     */
    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }

    /**
     * 获取名称
     *
     * @return provincename - 名称
     */
    public String getProvincename() {
        return provincename;
    }

    /**
     * 设置名称
     *
     * @param provincename 名称
     */
    public void setProvincename(String provincename) {
        this.provincename = provincename;
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