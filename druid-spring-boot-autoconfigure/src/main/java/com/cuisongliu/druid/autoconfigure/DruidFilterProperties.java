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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * druid filter properties
 * @author cuisongliu
 * @since 2017/2/5.
 */
@ConfigurationProperties(prefix = DruidFilterProperties.DRUID_FILTER_PREFIX)
public class DruidFilterProperties {
    public static final String DRUID_FILTER_PREFIX = DruidProperties.DRUID_PREFIX+".filter";
    /**
     * 是否加入druid拦截器,默认为false
     */
    private Boolean enable = false;
    /**
     * 拦截资源排除,默认为'*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*'
     */
    private String exclusions = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";
    /**
     * 需要拦截的Url,默认为'/*'
     */
    private String urlPattern = "/*";
    /**
     * 缺省sessionStatMaxCount是1000个。你可以按需要进行配置
     */
    private Integer sessionStatMaxCount = 1000;
    /**
     * session统计功能,默认为false
     */
    private Boolean sessionStatEnable = false;
    /**
     * 使得druid能够知道当前的session的用户是谁,默认为USER_SESSION
     */
    private String principalSessionName = "USER_SESSION";
    /**
     * 使得druid能够知道当前的cookie的用户是谁,默认为USER_COOKIE
     */
    private String principalCookieName = "USER_COOKIE";
    /**
     * profileEnable能够监控单个url调用的sql,，默认为true
     */
    private Boolean profileEnable = true;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public Integer getSessionStatMaxCount() {
        return sessionStatMaxCount;
    }

    public void setSessionStatMaxCount(Integer sessionStatMaxCount) {
        this.sessionStatMaxCount = sessionStatMaxCount;
    }

    public Boolean getSessionStatEnable() {
        return sessionStatEnable;
    }

    public void setSessionStatEnable(Boolean sessionStatEnable) {
        this.sessionStatEnable = sessionStatEnable;
    }

    public String getPrincipalSessionName() {
        return principalSessionName;
    }

    public void setPrincipalSessionName(String principalSessionName) {
        this.principalSessionName = principalSessionName;
    }

    public String getPrincipalCookieName() {
        return principalCookieName;
    }

    public void setPrincipalCookieName(String principalCookieName) {
        this.principalCookieName = principalCookieName;
    }

    public Boolean getProfileEnable() {
        return profileEnable;
    }

    public void setProfileEnable(Boolean profileEnable) {
        this.profileEnable = profileEnable;
    }
}
