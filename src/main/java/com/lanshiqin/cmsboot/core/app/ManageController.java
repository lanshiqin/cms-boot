package com.lanshiqin.cmsboot.core.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理面板控制器
 */
@Controller
public class ManageController {

    /**
     * 跳转到管理页面
     * @return 管理页面模板视图
     */
    @RequestMapping("/manage")
    public String toManage(){
        return "manage";
    }
}
