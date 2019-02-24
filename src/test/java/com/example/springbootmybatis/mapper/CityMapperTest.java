package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author wander
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityMapperTest {
    @Autowired
    private CityMapper cityMapper;

    @Test
    public void getCityById() {
        City city = cityMapper.getCityById(1);
        assertNotNull(city);
        assertNotNull(city.getProvince());
    }
}