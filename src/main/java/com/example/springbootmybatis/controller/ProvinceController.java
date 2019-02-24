package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.model.Province;
import com.example.springbootmybatis.service.ProvinceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 省份controller
 */
@RestController
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @RequestMapping
    public PageInfo<Province> getAll(Province province) {
        List<Province> provinceList = provinceService.getAll(province);
        return new PageInfo<>(provinceList);
    }

    @RequestMapping("/conditional")
    public List<Province> getAll() {
        List<Province> provinceList = provinceService.getByConditional();
        return provinceList;
    }

    @RequestMapping(value = "/view/{id}")
    public Province view(@PathVariable Integer id) {
        Province province = provinceService.getById(id);
        return province;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        provinceService.deleteById(id);
        result.put("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(Province province) {
        ModelMap result = new ModelMap();
        String msg = province.getId() == null ? "新增成功" : "更新成功";
        provinceService.save(province);
        result.put("province", province);
        result.put("msg", msg);
        return result;
    }
}