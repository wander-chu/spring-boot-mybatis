package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.model.City;
import com.example.springbootmybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市controller
 */
@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping(value = "/view/{id}")
    public City view(@PathVariable Integer id) {
        City city = cityService.getCityById(id);
        return city;
    }
}