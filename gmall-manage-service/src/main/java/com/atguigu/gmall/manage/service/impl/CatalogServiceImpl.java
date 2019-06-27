package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.manage.mapper.Catalog1Mapper;
import com.atguigu.gmall.manage.mapper.Catalog2Mapper;
import com.atguigu.gmall.manage.mapper.Catalog3Mapper;
import com.atguigu.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    /**
     * 一级分类信息表的通用mapper
     */
    @Autowired
    private Catalog1Mapper catalog1Mapper;
    /**
     * 二级分类信息表的通用Mapper
     */
    @Autowired
    private Catalog2Mapper catalog2Mapper;
    /**
     * 三级分类信息表的通用Mapper
     */
    @Autowired
    private Catalog3Mapper catalog3Mapper;


    /**
     * 查询所有一级分类的信息
     *
     * @return
     */
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = catalog1Mapper.selectAll();
        return pmsBaseCatalog1s;
    }

    /**
     * 根据catalog1Id查询catalog2
     *
     * @param catalog1Id
     * @return
     */
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = catalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }

    /**
     * 根据catalog2Id查询catalog3
     * @param catalog2Id
     * @return
     */
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = catalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }
}
