package com.example.springbootmybatis.model;

/**
 * 城市model
 */
public class City extends BaseEntity {
    /**
     * 城市名称
     */
    private String cityname;

    /**
     * 所属省份
     */
    private Province province;

    /**
     * 获取城市名称
     *
     * @return cityname - 城市名称
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * 设置城市名称
     *
     * @return cityname - 城市名称
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * 获取所属省份
     *
     * @return province - 省份
     */
    public Province getProvince() {
        return province;
    }

    /**
     * 设置所属省份
     *
     * @return province - 省份
     */
    public void setProvince(Province province) {
        this.province = province;
    }
}