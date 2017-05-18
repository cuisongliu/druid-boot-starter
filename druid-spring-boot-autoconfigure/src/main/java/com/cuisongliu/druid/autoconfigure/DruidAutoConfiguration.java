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

import com.alibaba.druid.pool.DruidDataSource;
import com.cuisongliu.druid.autoconfigure.stat.DruidStatAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author cuisongliu
 * @since 2017/2/5.
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@Import({DruidServletAutoConfiguration.class,DruidFilterAutoConfiguration.class, DruidStatAutoConfiguration.class})
public class DruidAutoConfiguration {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    @ConfigurationProperties(DruidProperties.DRUID_PREFIX)
    public DataSource dataSource(DruidProperties properties) {
        DruidDataSource datasource = (DruidDataSource) DataSourceBuilder
                .create()
                .type(DruidDataSource.class)
                .build();
        configDruid(datasource, properties);
        return datasource;
    }

    private void configDruid(DruidDataSource dataSource, DruidProperties properties) {
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        if (properties.getMaxWait() > 0 ){
            dataSource.setMaxWait(properties.getMaxWait());
        }
        if (properties.getTimeBetweenEvictionRunsMillis() > 0l){
            dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        }
        if (properties.getMaxOpenPreparedStatements() > 0 ){
            dataSource.setMaxOpenPreparedStatements(properties.getMaxOpenPreparedStatements());
        }
        if (properties.getMaxPoolPreparedStatementPerConnectionSize() > 0 ){
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        }
        if (properties.getValidationQueryTimeout() > 0 ){
            dataSource.setValidationQueryTimeout(properties.getValidationQueryTimeout());
        }
        if (properties.getMinEvictableIdleTimeMillis() > 0l){
            dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        }
        dataSource.setValidationQuery(properties.getValidationQuery());
        dataSource.setTestOnReturn(properties.getTestOnReturn());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestWhileIdle(properties.getTestWhileIdle());
        dataSource.setPoolPreparedStatements(properties.getPoolPreparedStatements());
        dataSource.setConnectProperties(properties.getConnectionProperties());
        try {
            dataSource.setFilters(properties.getFilters());
        } catch (SQLException e) {
            throw new IllegalArgumentException("please check your spring.datasource.druid.filters property.", e);
        }
    }
}
