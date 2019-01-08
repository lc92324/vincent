package com.example.demo.controller;

import com.example.demo.Task.Task;
import com.example.demo.domain.Message;
import com.example.demo.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController{


    @Autowired
    private Task taskExecutor;

    @Autowired
    MessageService messageService;

    @GetMapping("/insertMsg")
    @ResponseBody
    public Object insertMessage() throws Exception {
        List<Message> list = null;
        list = messageService.queryMsg();
        return successDTO(list);
    }


    @GetMapping("/index")
    public Object index(){
        return "msg";
    }




}
