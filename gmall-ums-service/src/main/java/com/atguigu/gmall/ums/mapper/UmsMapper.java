package com.atguigu.gmall.ums.mapper;

import com.atguigu.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UmsMapper extends Mapper<UmsMember>{//继承通用Mapper
    public List<UmsMember> getAllUms();
}
