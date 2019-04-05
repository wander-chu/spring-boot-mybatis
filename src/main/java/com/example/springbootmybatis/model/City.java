package com.example.springbootmybatis.model;

/**
 * 城市model
 */
public class City extends BaseEntity {
    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 省份Id
     */
    private Integer pId;

    /**
     * 所属省份
     */
    private Province province;

    /**
     * 获取城市名称
     *
     * @return cityName - 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市名称
     *
     * @return cityName - 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取省份Id
     *
     * @return pid 省份Id
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * 设置省份Id
     *
     * @param pId 省份Id
     */
    public void setpId(Integer pId) {
        this.pId = pId;
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