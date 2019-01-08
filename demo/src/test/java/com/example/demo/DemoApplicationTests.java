package com.example.demo;

import com.example.demo.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        List<Message> list = new ArrayList<>();
        List<Message> listAll = new ArrayList<>();
        list.add( new Message("22","3333"));
        listAll.addAll(list);
        System.out.println( listAll.size());
    }

}

