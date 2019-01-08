package com.tuhui.socialsecurity.exceptions;


import com.tuhui.socialsecurity.enums.ResponseStatusEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description : 统一处理异常
 * @author : lchao
 * @CreateDate : 2019-01-07
 *
 */
@ControllerAdvice
public class GlobalException {


    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Object MyException(Exception e){
        return returnJson(ResponseStatusEnum.RESULT_STATUS_400.getCode(),"服务器异常!");
    }

    @ExceptionHandler(MyLoginException.class)
    @ResponseBody
    public Object MyLoginException(Exception e){
        return returnJson(ResponseStatusEnum.RESULT_STATUS_400.getCode(),e.getMessage());
    }


    /**
     * json格式返回结果
     *
     * @param resCode
     * @param errorMsg
     * @return
     */
    public  Map<String, Object> returnJson(int resCode, String errorMsg) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("status", resCode);
        jsonMap.put("msg", errorMsg);
        return jsonMap;
    }
}
