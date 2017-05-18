package com.cuisongliu.druid.autoconfigure.stat;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@EnableConfigurationProperties(DruidStatProperties.class)
@ConditionalOnProperty(name = DruidStatProperties.DRUID_STAT_PREFIX +".enable", havingValue = "true")
@Import({DruidTypeAopAutoConfiguration.class})
public class DruidStatAutoConfiguration {

}
