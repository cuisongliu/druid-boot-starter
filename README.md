[![Build Status](https://travis-ci.org/cuisongliu/druid-boot-starter.svg?branch=master)](https://travis-ci.org/cuisongliu/druid-boot-starter)
[![Dependency Status](https://www.versioneye.com/user/projects/5918687ae1638f0051a0a62c/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5918687ae1638f0051a0a62c)
[![license](https://img.shields.io/badge/gradle-3.3-brightgreen.svg)](https://gradle.org)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/mit-license.php)

#  [Druid](https://github.com/alibaba/druid)  integration  with springboot

Druid-Spring-Boot-Starter 帮助你集成通用 [Druid](https://github.com/alibaba/druid) 到 Spring Boot。

Druid-Spring-Boot-Starter will help you use [Druid](https://github.com/alibaba/druid) with Spring Boot.

## How to use

### maven

在pom.xml加入nexus资源库

Add the following nexus repository to your pom.xml:

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
       <groupId>com.cuisongliu</groupId>
       <artifactId>druid-spring-boot-starter</artifactId>
       <version>1.0</version>
     </dependency>

### gradle

在build.gradle加入nexus资源库

Add the following nexus repository to your build.gradle:

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
    
    compile "com.cuisongliu:druid-spring-boot-starter:1.0"
    
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



## Acknowledgments

 [druid](https://github.com/alibaba/druid).