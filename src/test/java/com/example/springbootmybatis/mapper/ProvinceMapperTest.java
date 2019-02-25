package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        System.out.println("测试延迟加载，请在控制台查看执行日志");
        System.out.println("这里还没有执行子查询……");
        provinces.get(0).getCities();
        System.out.println("这里已经执行了子查询……");
        assertNotNull(provinces);
        assertTrue(provinces.size() > 0);
    }

    @Test
    public void getAllProvincesByProvinceNameOrProvinceCodeList() {
        List<String> codes = Arrays.asList("HN", "HB");
        List<Map<String, Object>> provinces = provinceMapper.getAllProvincesByProvinceNameOrProvinceCodeList("山东", codes);
        assertNotNull(provinces);
        assertTrue(provinces.size() > 0);
    }

    @Test
    @Transactional
    public void testL1Cache() {
        System.out.println("测试一级缓存");
        System.out.println("如果不加@Transactional则断言会失败，因为一级缓存只存在于SqlSession的生命周期中，\n" +
                "而Spring中SqlSession的管理机制导致每次查询SqlSession是不同实例，\n" +
                "加上@Transactional则SqlSession是同一个，所以一级缓存有效。");
        Province province = provinceMapper.selectByPrimaryKey(1);
        Province province2 = provinceMapper.selectByPrimaryKey(1);
        assertEquals(province, province2);
    }

    @Test
    @Rollback
    public void testL2Cache() {
        System.out.println("测试二级缓存");
        System.out.println("通过控制台日志可以看出不加@Transactional仍然使用了缓存，这里用的是二级缓存,\n" +
                "因为我们配置的缓存是可读写的，所以返回不同的实例，否则将返回同一个实例。");
        Province province = provinceMapper.selectByPrimaryKey(1);
        Province province2 = provinceMapper.selectByPrimaryKey(1);
        assertNotEquals(province, province2);
    }
}