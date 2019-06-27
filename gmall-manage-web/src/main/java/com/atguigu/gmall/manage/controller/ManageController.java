package com.atguigu.gmall.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageController {
    //通过


    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
