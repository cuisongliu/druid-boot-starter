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

import com.alibaba.druid.pool.DruidAbstractDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 *  druid数据源的基础属性
 *
 * @author cuijinrui
 * @since 2017/5/14
 */
@ConfigurationProperties(prefix = DruidProperties.DRUID_PREFIX)
public class DruidProperties {
    public static final String DRUID_PREFIX = "spring.datasource.druid";
    /**
     * 初始化时建立物理连接的个数。默认为0 <br/>
     * 初始化发生在显示调用init方法，或者第一次getConnection时
     */
    private int initialSize = DruidAbstractDataSource.DEFAULT_INITIAL_SIZE;
    /**
     * 最大连接池数量, 默认为8 <br/>
     */
    private int maxActive = DruidAbstractDataSource.DEFAULT_MAX_ACTIVE_SIZE;
    /**
     * 最小连接池数量, 默认为0 <br/>
     */
    private int minIdle = DruidAbstractDataSource.DEFAULT_MIN_IDLE;
    /**
     * 获取连接时最大等待时间，单位毫秒。默认为-1 <br/>
     * 配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，<br/>
     * 如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
     */
    private int maxWait = DruidAbstractDataSource.DEFAULT_MAX_WAIT;
    /**
     * 是否缓存preparedStatement，也就是PSCache。默认为false
     * PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
     */
    private Boolean poolPreparedStatements = false;
    /**
     * 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。<br/>
     * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100<br/>
     * 默认为 -1
     */
    private Integer maxPoolPreparedStatementPerConnectionSize = -1;
    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。<br/>
     * 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
     */
    private String validationQuery = DruidAbstractDataSource.DEFAULT_VALIDATION_QUERY;
    /**
     * 单位：秒，检测连接是否有效的超时时间。默认为 -1 <br/>
     * 底层调用jdbc Statement对象的void setQueryTimeout(int seconds)方法
     */
    private Integer validationQueryTimeout = -1;
    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。默认为false
     */
    private boolean testOnBorrow = DruidAbstractDataSource.DEFAULT_TEST_ON_BORROW;
    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。默认为false
     */
    private Boolean testOnReturn = DruidAbstractDataSource.DEFAULT_TEST_ON_RETURN;
    /**
     * 建议配置为true，不影响性能，并且保证安全性。默认为true<br/>
     * 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     *
     */
    private Boolean testWhileIdle = DruidAbstractDataSource.DEFAULT_WHILE_IDLE;
    /**
     *  有两个含义：<br/>
     *  1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvictableIdleTimeMillis则关闭物理连接。<br/>
     *  2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明<br/>
     *  默认为60000L
     */
    private Long timeBetweenEvictionRunsMillis = DruidAbstractDataSource.DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS;
    /**
     *  连接保持空闲而不被驱逐的最长时间.默认为1800000L
     */
    private Long minEvictableIdleTimeMillis = DruidAbstractDataSource.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;

    /**
     * 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：<br/>
     * 监控统计用的filter:stat<br/>
     * 日志用的filter:log4j<br/>
     * 防御sql注入的filter:wall<br/>
     */
    private String filters = "stat";

    /**
     * 额外的属性,例如慢查询等参数.
     */
    private Properties connectionProperties;

    public Properties getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(Properties connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public Long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(Long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public Boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public Integer getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(Integer maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public Integer getValidationQueryTimeout() {
        return validationQueryTimeout;
    }

    public void setValidationQueryTimeout(Integer validationQueryTimeout) {
        this.validationQueryTimeout = validationQueryTimeout;
    }

    public Long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

}
