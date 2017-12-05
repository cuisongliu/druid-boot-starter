[![Build Status](https://travis-ci.org/cuisongliu/druid-boot-starter.svg?branch=master)](https://travis-ci.org/cuisongliu/druid-boot-starter)
[![Dependency Status](https://www.versioneye.com/user/projects/5918687ae1638f0051a0a62c/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5918687ae1638f0051a0a62c)
[![license](https://img.shields.io/badge/gradle-3.3-brightgreen.svg)](https://gradle.org)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/mit-license.php)

#  [Druid](https://github.com/alibaba/druid)  integration  with springboot

Druid-Spring-Boot-Starter 帮助你集成通用 [Druid](https://github.com/alibaba/druid) 到 Spring Boot。

Druid-Spring-Boot-Starter will help you use [Druid](https://github.com/alibaba/druid) with Spring Boot.

## How to use

### maven

在pom.xml加入nexus资源库（解决中国访问慢的问题,已经加入中央仓库）

Add the following nexus repository(fix china access slow problem,already append to central nexus.)  to your pom.xml:

    <repositories>
        <repository>
            <id>nexus</id>
            <name>nexus</name>
            <url>http://maven.cuisongliu.com/content/groups/public</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

在pom.xml加入依赖

Add the following dependency to your pom.xml:
    
    <dependency>
           <groupId>com.alibaba</groupId>
           <artifactId>druid</artifactId>
           <version>1.1.5</version>
    </dependency>
    <dependency>
       <groupId>com.cuisongliu</groupId>
       <artifactId>druid-spring-boot-starter</artifactId>
       <version>1.2</version>
     </dependency>

### gradle

在build.gradle加入nexus资源库（解决中国访问慢的问题,已经加入中央仓库）

Add the following nexus repository(fix china access slow problem,already append to central nexus.)  to your build.gradle:

    allprojects {
        repositories {
            mavenLocal()
            maven { url "http://maven.cuisongliu.com/content/groups/public" }
            mavenCentral()
            jcenter()
        }
    }
    
在build.gradle加入依赖

Add the following dependency to your build.gradle:
    
    compile "com.alibaba:druid:1+"
    compile "com.cuisongliu:druid-spring-boot-starter:1+"
    
### springboot properties set

在application.properties 或者application.yml加入[相关参数](https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE%E5%B1%9E%E6%80%A7%E5%88%97%E8%A1%A8)

at  application.properties or application.yml append some properties.

| properties | IsNull? | Defaults |
| :------|:------|:------|
|spring.datasource.url|no|null|
|spring.datasource.username|no|null|
|spring.datasource.password|no|null|
|spring.datasource.druid.max-active|yes|8|
|spring.datasource.druid.min-idle|yes|0|
|spring.datasource.druid.initial-size|yes|0|
|spring.datasource.druid.max-wait|yes|-1|
|spring.datasource.druid.time-between-eviction-runs-millis|yes|60 * 1000L|
|spring.datasource.druid.max-open-prepared-statements|yes|-1|
|spring.datasource.druid.test-on-borrow|yes|false|
|spring.datasource.druid.validation-query|yes|null|
|spring.datasource.druid.test-on-return|yes|false|
|spring.datasource.druid.test-while-idle|yes|true|
|spring.datasource.druid.pool-prepared-statements|yes|false|
|spring.datasource.druid.filters|yes|false|
|spring.datasource.druid.max-pool-prepared-statement-per-connection-size|yes|-1|
|spring.datasource.druid.validation-query-timeout|yes|-1|
|spring.datasource.druid.min-evictable-idle-time-millis|yes|1000L * 60L * 30L|
|spring.datasource.druid.connection-properties|yes|null|

sql slow config:

    spring:
     datasource:
        druid:
          connection-properties:
            - druid.stat.mergeSql=true
            - druid.stat.slowSqlMillis=5000

[servlet properties](https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatViewServlet%E9%85%8D%E7%BD%AE)

| properties | IsNull? | Defaults |
| :------|:------|:------|
|spring.datasource.druid.servlet.enable|yes|true|
|spring.datasource.druid.servlet.url-mappings|yes|/druid/*|
|spring.datasource.druid.servlet.allow|yes|null|
|spring.datasource.druid.servlet.deny|yes|null|
|spring.datasource.druid.servlet.login-username|yes|null|
|spring.datasource.druid.servlet.login-password|yes|null|
|spring.datasource.druid.servlet.reset-enable|yes|null|

[filter properties](https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_%E9%85%8D%E7%BD%AEWebStatFilter)

| properties | IsNull? | Defaults |
| :------|:------|:------|
|spring.datasource.druid.servlet.enable|yes|false|
|spring.datasource.druid.servlet.exclusions|yes|*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*|
|spring.datasource.druid.servlet.url-pattern|yes|/*|
|spring.datasource.druid.servlet.session-stat-max-count|yes|1000|
|spring.datasource.druid.servlet.session-stat-enable|yes|false|
|spring.datasource.druid.servlet.principal-session-name|yes|USER_SESSION|
|spring.datasource.druid.servlet.principal-cookie-name|yes|USER_COOKIE|
|spring.datasource.druid.servlet.profile-enable|yes|true|

[stat properties](https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_Druid%E5%92%8CSpring%E5%85%B3%E8%81%94%E7%9B%91%E6%8E%A7%E9%85%8D%E7%BD%AE)

| properties | IsNull? | Defaults |
| :------|:------|:------|
|spring.datasource.druid.stat.enable|yes|false|
|spring.datasource.druid.stat.aop-types|yes|null|
|spring.datasource.druid.stat.target-bean-type|yes|null|
|spring.datasource.druid.stat.bean-names|yes|null|
/spring.datasource.druid.stat.patterns|yes|null|

spring.datasource.druid.stat.aop-types  待选值有[ ***type,name,pointcut*** ]

当enable=true时候,aop-types必须有type或者name的其中一项.

- 当aop-types有name值时,bean-names不能为空.
- 当aop-types有type值时,target-bean-type不能为空.
- 当aop-types有pointcut值时,patterns不能为空.

spring.datasource.druid.stat.aop-types  selected value is [ ***type,name,pointcut*** ]


When ```enable=true``` , aop-types must have either ```type``` or  ```name```.

 - When ```aop-types``` has ```name``` value, ```bean-names``` can not be null.
 - When ```aop-types``` have ```type``` values, ```target-bean-type``` can not be empty.
 - When ```aop-types``` have ```pointcut``` values, ```patterns``` can not be empty.

## Example


    spring:
      datasource:
        url: xxx
        username: xxx
        password: xxx
        druid:
              filters: stat,wall,log4j
              connection-properties:
                - druid.stat.mergeSql=true
                - druid.stat.slowSqlMillis=5000
              filter:
                enable: true
                principal-session-name: session_admin
                profile-enable: true
                principal-cookie-name: session_admin
                session-stat-enable: true
              stat:
                enable: true
                aop-type: 
                   - name
                   - type
                   - pointcut
                target-bean-type: com.cuisongliu.springboot.core.mapper.MyMapper
                bean-names:
                   - UserMapper
                   - userMapper
                patterns:
                  - com.xinyuewulian.mapper.*
                  - com.xinyuewulian.service.*

## Acknowledgments

 [druid](https://github.com/alibaba/druid).