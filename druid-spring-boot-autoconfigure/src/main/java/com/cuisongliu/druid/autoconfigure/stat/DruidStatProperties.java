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
package com.cuisongliu.druid.autoconfigure.stat;


import com.cuisongliu.druid.autoconfigure.DruidProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = DruidStatProperties.DRUID_STAT_PREFIX)
public class DruidStatProperties {
    public static final String DRUID_STAT_PREFIX = DruidProperties.DRUID_PREFIX+".stat";
    public static final String DRUID_STAT_INTERCEPTOR_NAME = "druid-stat-interceptor";
    private Boolean enable = false;
    private String aopType ="";
    private Class<?> targetBeanType;

    public String getAopType() {
        return aopType;
    }

    public void setAopType(String aopType) {
        this.aopType = aopType;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Class<?> getTargetBeanType() {
        return targetBeanType;
    }

    public void setTargetBeanType(Class<?> targetBeanType) {
        this.targetBeanType = targetBeanType;
    }
}
