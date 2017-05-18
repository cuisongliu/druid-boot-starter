package com.cuisongliu.druid.autoconfigure.stat;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.aopalliance.intercept.Interceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

public class DruidStatInitAutoConfiguration {

    @Bean(DruidStatProperties.DRUID_STAT_INTERCEPTOR_NAME)
    @ConfigurationProperties(DruidStatProperties.DRUID_STAT_PREFIX)
    public Interceptor druidStatInterceptor(DruidStatProperties properties){
        Interceptor interceptor = new DruidStatInterceptor();
        if (properties.getAopType().equals("type") ){
            return      interceptor;
        }else {
            throw new IllegalStateException(DruidStatProperties.DRUID_STAT_PREFIX+".aop-type must be [type]");
        }
    }
}
