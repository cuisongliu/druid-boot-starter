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

import java.util.ArrayList;
import java.util.List;

/**
 * stat和spring监控关联的参数
 *
 * @author cuisongliu
 * @since 2017年5月20日 11:15:26
 */
@ConfigurationProperties(prefix = DruidStatProperties.DRUID_STAT_PREFIX)
public class DruidStatProperties {
    public static final String DRUID_STAT_PREFIX = DruidProperties.DRUID_PREFIX + ".stat";
    public static final String DRUID_STAT_INTERCEPTOR_NAME = "druid-stat-interceptor";
    /**
     * druid spring stat是否开启,默认为false
     */
    private Boolean enable = false;
    /**
     * aop spring监控类型
     */
    private List<AopType> aopTypes = new ArrayList<AopType>();
    /**
     * 当aopTypes=type所用 ,监控该抽象类或者接口的所有的实现方法.
     */
    private Class<?> targetBeanType;

    /**
     * 当aopTypes=name所用,监控所有的beanNames
     */
    private List<String> beanNames;

    public List<AopType> getAopTypes() {
        return aopTypes;
    }

    public void setAopTypes(List<AopType> aopTypes) {
        this.aopTypes = aopTypes;
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

    public List<String> getBeanNames() {
        return beanNames;
    }

    public void setBeanNames(List<String> beanNames) {
        this.beanNames = beanNames;
    }


    public enum AopType {
        /**
         * aop 类型为name 则beanNames属性不能为空
         */
        name("name"),
        /**
         * aop 类型为type 则targetBeanType属性不能为空
         */
        type("type");
        private String value;

        AopType(String value) {
            this.value = value;
        }


        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
