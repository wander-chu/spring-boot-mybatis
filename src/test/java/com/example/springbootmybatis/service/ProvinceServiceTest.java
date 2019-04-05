package com.example.springbootmybatis.service;

import com.example.springbootmybatis.model.City;
import com.example.springbootmybatis.model.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProvinceServiceTest {
    @Autowired
    ProvinceService provinceService;

    @Test
    public void saveProvinceAndCities() {
        Province province = new Province();
        province.setProvinceCode("1");
        province.setProvinceName("省份1");
        List<City> cities = new ArrayList<>();
        City city = new City();
        city.setCityName("城市1");
        cities.add(city);
        city = new City();
        city.setCityName("城市2");
        cities.add(city);
        try {
            provinceService.saveProvinceAndCities(province, cities);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}