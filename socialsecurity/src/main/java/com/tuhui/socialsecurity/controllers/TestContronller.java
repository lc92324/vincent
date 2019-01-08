package com.tuhui.socialsecurity.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContronller extends BaseController{


    @RequestMapping("/test")
    public Object test(){
        return successDTO("ok");
    }

    @RequestMapping("/login")
    public Object login(){
        return successDTO("ok");
    }

}
