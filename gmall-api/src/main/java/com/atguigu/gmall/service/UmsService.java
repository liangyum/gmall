package com.atguigu.gmall.service;


import com.atguigu.gmall.bean.UmsMember;

import java.util.List;

public interface UmsService {
    public List<UmsMember> getAllUms();

    UmsMember getUmsById(String id);

    Integer deleteUmsById(String id);

    Integer saveUms(UmsMember umsMember);

    Integer updateUmsById(UmsMember umsMember);
}
