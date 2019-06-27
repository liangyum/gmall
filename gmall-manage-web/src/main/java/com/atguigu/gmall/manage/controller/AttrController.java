package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.service.PmsBaseAttrInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 负责处理平台属性相关请求
 */
@RestController
@CrossOrigin
public class AttrController {
    /**
     * 远程调用pmsbaseattrinfo服务的接口
     */
    @Reference
    private PmsBaseAttrInfoService pmsBaseAttrInfoService;

    /**
     * 根据catalog3Id获取对应的平台属性
     * @param catalog3Id
     * @return
     */
    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoService.attrInfoList(catalog3Id);
        return  pmsBaseAttrInfos;
    }

    /**
     * 保存三级分类对应的平台属性
     * @param pmsBaseAttrInfo
     * @return
     */
    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        pmsBaseAttrInfoService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }
}
