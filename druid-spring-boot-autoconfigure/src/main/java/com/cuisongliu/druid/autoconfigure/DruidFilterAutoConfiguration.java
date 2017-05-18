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

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(DruidFilterProperties.class)
@ConditionalOnProperty(name = DruidFilterProperties.DRUID_FILTER_PREFIX+".enable", havingValue = "true")
public class DruidFilterAutoConfiguration {

    @Bean
    @ConfigurationProperties(DruidFilterProperties.DRUID_FILTER_PREFIX)
    public FilterRegistrationBean druidFilter(DruidFilterProperties properties) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        WebStatFilter filter = new WebStatFilter();
        registration.setFilter(filter);
        registration.addUrlPatterns(properties.getUrlPattern());
        registration.addInitParameter("exclusions",properties.getExclusions());
        registration.addInitParameter("sessionStatMaxCount",properties.getSessionStatMaxCount().toString());
        registration.addInitParameter("sessionStatEnable",properties.getSessionStatEnable().toString());
        registration.addInitParameter("principalSessionName",properties.getPrincipalSessionName());
        registration.addInitParameter("principalCookieName",properties.getPrincipalCookieName());
        registration.addInitParameter("profileEnable",properties.getProfileEnable().toString());
        return registration;
    }
}
