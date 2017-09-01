package com.lanshiqin.cmsboot.core.bean;

/**
 * Created by 蓝士钦 on 2017/7/7.
 * Json数据格式实体类
 */
public class JsonDataBean {
    private String code;    //状态码
    private String message; //响应信息
    private Object data;    //响应数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
