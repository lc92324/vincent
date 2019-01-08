package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 审批结果返回信息
 *
 * @auther wangping
 * @create 下午2:22
 */
@Data
public class ResultDTO implements Serializable{

    private static final long serialVersionUID = -5502705778654524889L;

    public ResultDTO(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回状态码
     */
    private String status;


    /**
     * 返回状态信息
     */
    private String msg;


    /**
     * 返回数据
     */
    private Object data;

}
