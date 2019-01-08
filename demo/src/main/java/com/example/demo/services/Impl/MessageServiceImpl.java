package com.example.demo.services.Impl;

import com.example.demo.domain.Message;
import com.example.demo.repository.MessageRepository;
import com.example.demo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    MessageRepository messageRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public  void save(List<Message> list){
        messageRepository.saveAll(list);



        jdbcTemplate.batchUpdate(" insert into message (number,num,content,date,phone) values (?,?,?,?,?);", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1,list.get(i).getNumber());
                ps.setString(2,list.get(i).getNum());
                ps.setString(3,list.get(i).getContent());
                ps.setString(4,list.get(i).getDate());
                ps.setString(5,list.get(i).getPhone());
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        });
    }

    @Override
    public List<Message> queryMsg() {
        return  messageRepository.findByContentContaining("兴业银行");
    }

    @Override
    public void deleteAllInBatch() {
        messageRepository.deleteAllInBatch();
    }
}
