package com.example.springbootmybatis.service;

import com.example.springbootmybatis.mapper.ProvinceMapper;
import com.example.springbootmybatis.model.Province;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Arrays;
import java.util.List;

/**
 * 省份service
 */
@Service
public class ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;

    /**
     * 通过条件获取省份列表
     * 名称中包含“江”并且代码中包含“X”的身份，或者名称为“山东”的省份，或者代码为“XJ”和"SC"的省份
     * 显示时按照代码倒序排列，如果名称一样则按id正序排列
     *
     * @return 省份列表
     */
    public List<Province> getByConditional() {
        Weekend<Province> weekend = Weekend.of(Province.class);
        WeekendCriteria<Province, Object> criteria = weekend.weekendCriteria();
        criteria.andLike(Province::getProvincename, "%" + "江" + "%");
        criteria.andLike(Province::getProvincecode, "%" + "X" + "%");

        //添加or条件
        WeekendCriteria<Province, Object> criteria2 = weekend.weekendCriteria();
        criteria2.andEqualTo(Province::getProvincename, "山东");
        weekend.or(criteria2);

        WeekendCriteria<Province, Object> criteria3 = weekend.weekendCriteria();
        criteria3.andIn(Province::getProvincecode, Arrays.asList("XJ","SC"));
        weekend.or(criteria3);

        //排序
        weekend.setOrderByClause("provincecode desc, id asc");
        return provinceMapper.selectByExample(weekend);
    }

    /**
     * 获取省份列表
     *
     * @param province 省份实体对象
     * @return 省份列表
     */
    public List<Province> getAll(Province province) {
        if (province.getPage() != null && province.getRows() != null) {
            PageHelper.startPage(province.getPage(), province.getRows());
        }

        return provinceMapper.selectAll();
    }

    /**
     * 根据id获取省份信息
     *
     * @param id 主键
     * @return 省份实体对象
     */
    public Province getById(Integer id) {
        return provinceMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id删除省份信息
     *
     * @param id 主键
     */
    public void deleteById(Integer id) {
        provinceMapper.deleteByPrimaryKey(id);
    }

    /**
     * 保存省份信息
     *
     * @param province 省份实体对象
     */
    public void save(Province province) {
        if (province.getId() != null) {
            provinceMapper.updateByPrimaryKeySelective(province);
        } else {
            provinceMapper.insertSelective(province);
        }
    }
}