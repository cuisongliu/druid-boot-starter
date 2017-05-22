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

import com.cuisongliu.druid.autoconfigure.condition.PointcutAopTypesCondition;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * 方法名正则匹配拦截配置
 *
 * @author cuisongliu [cuisongliu@qq.com]
 * @since 2017-05-22 10:26
 */
@Conditional(PointcutAopTypesCondition.class)
public class DruidPointcutAopAutoConfiguration extends DruidStatInitAutoConfiguration{
    @Value("${spring.aop.proxy-target-class:false}")
    private boolean proxyTargetClass;

    @Bean
    public Pointcut pointcut(DruidStatProperties properties) {
        if (properties.getPatterns().length <= 0){
            throw new IllegalStateException(DruidStatProperties.DRUID_STAT_PREFIX+".target-bean-type must  not null.");
        }
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns(properties.getPatterns());
        return pointcut;
    }

    @Bean
    public Advisor advisor(DruidStatProperties properties){
        return new DefaultPointcutAdvisor(pointcut(properties),druidStatInterceptor());
    }

    @Bean
    @ConfigurationProperties(DruidStatProperties.DRUID_STAT_PREFIX)
    public DefaultAdvisorAutoProxyCreator regexpProxyCreator(DruidStatProperties properties){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(proxyTargetClass);
        return  creator;
    }
}
