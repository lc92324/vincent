package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "message")
public class Message implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="number")
    private String number;

    @Column(name="num")
    private String num;

    @Column(name="content")
    private String content;

    @Column(name="date")
    private String date;

    @Column(name="phone")
    private String phone;


    public Message(){}

    public Message(String num ,String number){
        this.num = num;
        this.number = number;
    }

}
