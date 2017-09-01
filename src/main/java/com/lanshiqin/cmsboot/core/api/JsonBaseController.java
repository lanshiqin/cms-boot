package com.lanshiqin.cmsboot.core.api;

import com.lanshiqin.cmsboot.core.bean.JsonDataBean;

/**
 * Created by 蓝士钦 on 2017/7/7.
 * Json控制器抽象基类
 */
public abstract class JsonBaseController {
    /**
     * 返回状态码
     *
     * @param code 状态码
     * @return 带状态码的实体对象
     */
    protected JsonDataBean getJsonDataBean(String code) {
        JsonDataBean jsonDataBean = new JsonDataBean();
        jsonDataBean.setCode(code);
        return jsonDataBean;
    }

    /**
     * 返回状态码和信息对象
     *
     * @param code    状态码
     * @param message 响应信息
     * @return 带状态码和响应信息的实体对象
     */
    protected JsonDataBean getJsonDataBean(String code, String message) {
        JsonDataBean jsonDataBean = new JsonDataBean();
        jsonDataBean.setCode(code);
        jsonDataBean.setMessage(message);
        return jsonDataBean;
    }

    /**
     * 返回状态码和信息对象和响应数据对象
     *
     * @param code    状态码
     * @param message 响应信息
     * @param data    响应数据
     * @return 带状态码和响应信息和响应数据的实体对象
     */
    protected JsonDataBean getJsonDataBean(String code, String message, Object data) {
        JsonDataBean jsonDataBean = new JsonDataBean();
        jsonDataBean.setCode(code);
        jsonDataBean.setMessage(message);
        jsonDataBean.setData(data);
        return jsonDataBean;
    }
}
