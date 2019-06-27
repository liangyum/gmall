package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 负责处理三级分类先关请求
 */
@RestController
@CrossOrigin//解决跨域请求问题
public class CatalogController {
    // 用于远程调用manage-service服务的接口
    @Reference
    private CatalogService catalogService;

    /**
     * 获取所有一级分类信息
     * @return
     */
    @RequestMapping("getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1s = catalogService.getCatalog1();
        return catalog1s;
    }

    /**
     * 根据一级分类的id查询对应的二级分类信息
     * @param catalog1Id
     * @return
     */
    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }

    /**
     * 根据catalog2Id查询catalog3信息
     * @param catalog2Id
     * @return
     */
    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(
            @RequestParam("catalog2Id") String catalog2Id){
        List<PmsBaseCatalog3> PmsBaseCatalog3s = catalogService.getCatalog3(catalog2Id);
        return PmsBaseCatalog3s;
    }




}
