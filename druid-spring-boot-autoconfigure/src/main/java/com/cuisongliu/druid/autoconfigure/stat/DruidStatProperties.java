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
