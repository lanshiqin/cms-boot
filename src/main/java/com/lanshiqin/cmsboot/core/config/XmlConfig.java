package com.lanshiqin.cmsboot.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 导入工程的xml配置文件
 */
@Configuration
@ImportResource("classpath:shiro-spring.xml")
public class XmlConfig {
}
