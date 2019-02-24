package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wander
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProvinceMapperTest {
    @Autowired
    ProvinceMapper provinceMapper;

    @Test
    public void findProvincesExistsCity() {
        List<Province> provinces = provinceMapper.getProvincesExistsCity();
        assertNotNull(provinces);
        assertTrue(provinces.size() > 0);
    }

    @Test
    public void getAllProvinces() {
        List<Province> provinces = provinceMapper.getAllProvinces();
        assertNotNull(provinces);
        assertTrue(provinces.size() > 0);
    }
}