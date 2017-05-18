/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 cuisongliu@qq.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cuisongliu.druid.autoconfigure;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


/**
 * druid servlet auto config
 * @author cuisongliu
 * @since 2017/5/18
 */
@EnableConfigurationProperties(DruidServletProperties.class)
@ConditionalOnProperty(name =DruidServletProperties.DRUID_SERVLET_PREFIX+ ".enable", havingValue = "true", matchIfMissing = true)
public class DruidServletAutoConfiguration {

    @Bean
    @ConfigurationProperties(DruidServletProperties.DRUID_SERVLET_PREFIX)
    public ServletRegistrationBean druidServlet(DruidServletProperties properties) {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings(properties.getUrlMappings());
        if(properties.getAllow() !=null){
            reg.addInitParameter("allow", properties.getAllow());  // IP白名单 (没有配置或者为空，则允许所有访问)
        }
        if(properties.getDeny() !=null){
            reg.addInitParameter("deny", properties.getDeny()); //IP黑名单 (存在共同时，deny优先于allow)
        }
        if(properties.getLoginUsername() !=null){
            reg.addInitParameter("loginUsername", properties.getLoginUsername()); //用户名
        }
        if(properties.getLoginPassword() !=null){
            reg.addInitParameter("loginPassword", properties.getLoginPassword()); // 密码
        }
        if(properties.getResetEnable() !=null){
            reg.addInitParameter("resetEnable", properties.getResetEnable());// 禁用HTML页面上的“Reset All”功能
        }
        return reg;
    }
}
