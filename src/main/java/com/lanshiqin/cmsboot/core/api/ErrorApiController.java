package com.lanshiqin.cmsboot.core.api;

import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 蓝士钦 on 2017/7/12.
 * 错误信息控制器
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("error")
public class ErrorApiController extends JsonBaseController {

    @RequestMapping(value = "/noPermission")
    public JsonDataBean noPermission() {
        return getJsonDataBean("300", "你没有权限");
    }

    @RequestMapping(value = "/requestIllegal")
    public JsonDataBean requestIllegal() {
        return getJsonDataBean("301", "非法请求");
    }

    @RequestMapping(value = "/badRequest")
    public JsonDataBean badRequest() {
        return getJsonDataBean("400", "错误的请求");
    }

    @RequestMapping(value = "/notFound")
    public JsonDataBean notFound() {
        return getJsonDataBean("404", "错误的路径");
    }

    @RequestMapping(value = "/serverError")
    public JsonDataBean serverError() {
        return getJsonDataBean("500", "服务器内部错误");
    }

    @RequestMapping(value = "/noParameter")
    public JsonDataBean noParameter() {
        return getJsonDataBean("201", "缺少必要参数");
    }

    @RequestMapping(value = "/tokenInvalid")
    public JsonDataBean tokenInvalid() {
        return getJsonDataBean("202", "token已过期");
    }

    @RequestMapping(value = "/methodNotAllowed")
    public JsonDataBean methodNotAllowed() {
        return getJsonDataBean("405", "请求方法错误");
    }

    @RequestMapping(value = "/unSupportedMediaType")
    public JsonDataBean unSupportedMediaType() {
        return getJsonDataBean("415", "不支持的请求媒体类型");
    }

    @RequestMapping(value = "/TOO_LARGE")
    public JsonDataBean tooLarge(){
        return getJsonDataBean("413","上传的文件超过大小限制");
    }

    @RequestMapping(value = "/AccessNotFound")
    public JsonDataBean AccessNotFound(){
        return getJsonDataBean("404","资源不存在");
    }

}
