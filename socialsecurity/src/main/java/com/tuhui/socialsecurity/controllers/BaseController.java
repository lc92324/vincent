package com.tuhui.socialsecurity.controllers;

import com.alibaba.fastjson.JSON;
import com.tuhui.socialsecurity.dto.ResultDTO;
import com.tuhui.socialsecurity.enums.ResponseStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 控制层基类.
 */
@Slf4j
public class BaseController {

    /**
     * 成功的Status Code.
     */
    public static final int RESCODE_OK = 200;
    /**
     * 失败的Status Code.
     */
    public static final int RESCODE_FAIL = 201;

    /**
     * The action execution was a failure.
     */
    public static final String ERROR = "error/error";

    /**
     * 转到error/error页面时,model里面存储的错位信息的键
     */
    public static final String ERRORKEY = "errorMsg";
    /**
     * 其它未知异常
     */
    public static final String UNKOWNEXCEPTION = "请求失败";


    /**
     * 获取默认ajax成功信息.并传递参数到页面
     *
     * @return
     */
    protected Map<String, Object> successResult(Object data) {
        return createJson(RESCODE_OK, "操作成功！", data);
    }


    protected Map<String, Object> successResult(Object data,String msg) {
        return createJson(RESCODE_OK, "操作成功！", data);
    }
    /**
     * 获取默认ajax成功信息.
     *
     * @return
     */
    protected Map<String, Object> successResult() {
        return createJson(RESCODE_OK, "操作成功！", Collections.EMPTY_MAP);
    }

    /**
     * 获取失败信息.
     *
     * @param msg
     * @return
     */
    protected Map<String, Object> failResult(String msg) {
        return createJson(RESCODE_FAIL, msg, Collections.EMPTY_MAP);
    }

    /**
     * 描述：组装json格式返回结果
     *
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    public static Map<String, Object> createJson(int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("status", resCode);
        jsonMap.put("msg", errorMsg);
        jsonMap.put("data", obj);
        return jsonMap;
    }



    /**
     * @param totalCount
     * @param dataList
     * @return
     */
    protected Map<String, Object> dataTableJson(int totalCount, List<?> dataList) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("total", totalCount);
        data.put("content", dataList == null ? Collections.EMPTY_LIST : dataList);
        return data;
    }

    /**
     * @param request
     * @param key
     * @param isNeed
     * @return
     */
    protected String getRequestParam(HttpServletRequest request, String key, boolean isNeed) {
        String result = StringUtils.defaultString(request.getParameter(key));
        if (isNeed && "".equals(result)) {
        }
        return result;
    }

    /**
     * 设置成功时返回的DTO
     *
     * @param o
     * @return
     */
    protected String successDTO(Object o) {
        ResultDTO resultDTO = new ResultDTO(
                String.valueOf(ResponseStatusEnum.RESULT_STATUS_200.getCode())
                , ResponseStatusEnum.RESULT_STATUS_200.getDesc(), o);

        return JSON.toJSONString(resultDTO);
    }


    /**
     * 设置失败时返回的DTO
     *
     * @param o
     * @return
     */
    protected String failDTO(String code, String desc, Object o) {
        ResultDTO resultDTO = new ResultDTO(code, desc, o);

        return JSON.toJSONString(resultDTO);
    }
}
