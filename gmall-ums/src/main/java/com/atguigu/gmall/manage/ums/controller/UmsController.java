package com.atguigu.gmall.manage.ums.controller;

import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.manage.ums.service.UmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UmsController {
    @Autowired
    private UmsService umsService;

    @RequestMapping("get/all/ums")
    @ResponseBody
    public List<UmsMember> getAllUmsMember(){
        return umsService.getAllUms();
    }

    @RequestMapping("get/ums/by/id/{id}")
    @ResponseBody
    public UmsMember getUmsById(@PathVariable("id") String id){
        return umsService.getUmsById(id);
    }

    @RequestMapping("delete/ums/by/id/{id}")
    @ResponseBody
    public String deleteUmsById(@PathVariable("id") String id) {
        Integer i = umsService.deleteUmsById(id);
        if (i > 0){
            return "删除成功";
        }
        return "删除失败";
    }

    @RequestMapping("save/ums")
    @ResponseBody
    public String saveUms(UmsMember umsMember){
        Integer i = umsService.saveUms(umsMember);
        if (i > 0  ){
            return "保存成功";
        }
        return "保存失败";
    }

    @RequestMapping("edit/ums/by/id")
    @ResponseBody
    public String editUmsById(UmsMember umsMember){
        Integer i = umsService.updateUmsById(umsMember);
        if (i > 0  ){
            return "更新成功";
        }
        return "更新失败";
    }
}
