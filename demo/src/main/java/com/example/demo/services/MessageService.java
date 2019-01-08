package com.example.demo.services;

import com.example.demo.domain.Message;

import java.util.List;

public interface MessageService {

    //保存业务信息给 个人中心 查看

    void save(List<Message> list);

    List<Message> queryMsg();

    void deleteAllInBatch();
}
