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
package com.cuisongliu.druid.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * druid servlet properties
 * @author cuisongliu
 * @since 2017/5/18
 */
@ConfigurationProperties(prefix = DruidServletProperties.DRUID_SERVLET_PREFIX)
public class DruidServletProperties {
    public static final String DRUID_SERVLET_PREFIX = DruidProperties.DRUID_PREFIX+".servlet";

    /**
     * 是否开启druid的监控页面显示,默认为true
     */
    private Boolean enable = true;
    /**
     * druid 监控页面的前缀默认为 '/druid/*'
     */
    private String urlMappings = "/druid/*";
    /**
     * IP白名单 (没有配置或者为空，则允许所有访问)
     */
    private String allow;
    /**
     * IP黑名单 (存在共同时，deny优先于allow)
     */
    private String deny;
    /**
     * 用户名
     */
    private String loginUsername;
    /**
     *  密码
     */
    private String loginPassword;
    /**
     * 禁用HTML页面上的“Reset All”功能 ,默认为false
     */
    private Boolean resetEnable =false;

    public String getUrlMappings() {
        return urlMappings;
    }

    public void setUrlMappings(String urlMappings) {
        this.urlMappings = urlMappings;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Boolean getResetEnable() {
        return resetEnable;
    }

    public void setResetEnable(Boolean resetEnable) {
        this.resetEnable = resetEnable;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
