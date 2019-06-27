package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.service.SpuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 负责处理spu商品信息相关请求
 */
@RestController
@CrossOrigin//解决跨域请求问题
public class SpuController {
    /**
     * 远程调用spu的service接口
     */
    @Reference
    private SpuService spuService;

    /**
     * 根据catalog3Id查询商品信息spu
     * @param catalog3Id
     * @return
     */
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }


    /**
     * 获取销售属性列表信息
     * @return
     */
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = spuService.baseSaleAttrList();
        return  pmsBaseSaleAttrs;
    }

    /**
     * 保存添加的spu信息：productName、description、catalog3Id、saleAttr和value
     * @param pmsProductInfo
     * @return
     */
    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam("file")MultipartFile multipartFile){
        System.err.println(multipartFile);
        return "https://img14.360buyimg.com/n0/jfs/t1/31698/11/11865/218814/5cb68870Ebf26e1bd/dbe080c29fb0aeff.jpg";
    }
}
