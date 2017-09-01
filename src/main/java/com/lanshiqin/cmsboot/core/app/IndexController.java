package com.lanshiqin.cmsboot.core.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主控制器
 * Index入口控制器
 */
@Controller
public class IndexController {

    /**
     * 跳转到index主页
     * @return 主页面index模板视图
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
