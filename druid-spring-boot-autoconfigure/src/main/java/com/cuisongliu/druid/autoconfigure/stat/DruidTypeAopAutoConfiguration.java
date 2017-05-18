package com.cuisongliu.druid.autoconfigure.stat;

import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@ConditionalOnProperty(name = DruidStatProperties.DRUID_STAT_PREFIX +".aop-type", havingValue = "type")
@Import({DruidStatInitAutoConfiguration.class})
public class DruidTypeAopAutoConfiguration {

    @Bean
    @ConfigurationProperties(DruidStatProperties.DRUID_STAT_PREFIX)
    public BeanTypeAutoProxyCreator proxyCreator(DruidStatProperties properties){
        BeanTypeAutoProxyCreator creator = new BeanTypeAutoProxyCreator();
        creator.setTargetBeanType(properties.getTargetBeanType());
        creator.setInterceptorNames(DruidStatProperties.DRUID_STAT_INTERCEPTOR_NAME);
        return  creator;
    }
}
