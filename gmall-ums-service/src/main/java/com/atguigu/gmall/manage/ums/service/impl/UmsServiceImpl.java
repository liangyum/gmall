package com.atguigu.gmall.manage.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.manage.ums.mapper.UmsMapper;
import com.atguigu.gmall.service.UmsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UmsServiceImpl implements UmsService {
    @Autowired
    private UmsMapper umsMapper;


    @Override
    public List<UmsMember> getAllUms() {

//        return umsMapper.getAllUms();
        return umsMapper.selectAll();
    }

    @Override
    public UmsMember getUmsById(String id) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        return umsMapper.selectOne(umsMember);
    }

    @Override
    public Integer deleteUmsById(String id) {
        return umsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer saveUms(UmsMember umsMember) {
        return umsMapper.insertSelective(umsMember);
    }

    @Override
    public Integer updateUmsById(UmsMember umsMember) {
        return umsMapper.updateByPrimaryKeySelective(umsMember);
    }
}
