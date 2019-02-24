package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.model.Province;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wander
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ProvinceControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * 测试添加省份接口
     *
     * @throws Exception
     * @author wander
     */
    @Test
    public void save() throws Exception {
        //构造要添加的省份信息
        Province province = new Province();
        //province.setId(1000);
        province.setProvinceCode("XJ");
        province.setProvinceName("新疆");

        //调用接口，传入添加的省份参数
        //ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/provinces/save")
                //.contentType(MediaType.APPLICATION_JSON_UTF8)
                //.content(mapper.writeValueAsString(province)))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("provinceCode", province.getProvinceCode())
                .param("provinceName", province.getProvinceName()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.msg", is("新增成功")))
                .andExpect(jsonPath("$.province", notNullValue()))
                .andExpect(jsonPath("$.province.id", not(0)))
                .andExpect(jsonPath("$.province.provinceCode", is("XJ")));
    }

    /**
     * 测试根据id获取省份接口
     *
     * @author wander
     */
    @Test
    public void view() throws Exception {
        mockMvc.perform(get("/provinces/view/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.provinceCode", is("SD")))
                .andExpect(jsonPath("$.provinceName", is("山东")));
    }

    /**
     * 测试获取省份接口
     *
     * @author wander
     */
    @Test
    public void getAll() throws Exception{
        mockMvc.perform(post("/provinces")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("page", "2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.pageNum", is(2)));
    }
}