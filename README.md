# Spring Boot集成MyBatis
Spring Boot集成MyBatis、通用Mapper、分页插件PageHelper。

## 功能支持
1. Spring Boot配置MyBatis的方法
2. 使用分页插件PageHelper物理分页
3. 通过通用Mapper提供的通用方法查询数据
4. 通过xml和注解中编写sql的方式查询数据
5. 一对一、一对多的关联关系查询（嵌套查询）
6. 标签if、where、foreach、bind等的用法
7. 查询结果返回Map的方法
8. 延迟加载的使用
9. 缓存的使用（MyBatis缓存、EhCache缓存）

## 后续功能
* 存储过程的使用
* Redis缓存
* 持续更新……

## 项目依赖
```xml
<properties>
    <mybatis.spring.version>2.0.0</mybatis.spring.version>
    <mapper.starter.version>2.0.3-beta1</mapper.starter.version>
    <pagehelper.starter.version>1.2.5</pagehelper.starter.version>
</properties>

<dependencies>
    <!--mybatis-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>${mybatis.spring.version}</version>
    </dependency>
    <!--mapper-->
    <dependency>
        <groupId>tk.mybatis</groupId>
        <artifactId>mapper-spring-boot-starter</artifactId>
        <version>${mapper.starter.version}</version>
    </dependency>
    <!--pagehelper-->
    <dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper-spring-boot-starter</artifactId>
        <version>${pagehelper.starter.version}</version>
    </dependency>
</dependencies>
```

## application.properties配置
```properties
# mybatis
mybatis.type-aliases-package=com.example.springbootmybatis.model
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.config-location=classpath:mybatis-config.xml

# mapper
# mappers 多个接口时逗号隔开
mapper.mappers=com.example.springbootmybatis.utils.MyMapper
mapper.not-empty=false
mapper.identity=MYSQL

# pagehelper
pagehelper.helperDialect=mysql
pagehelper.reasonable=true
pagehelper.supportMethodsArguments=true
pagehelper.params=count=countSql
```

## mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--配置节点是有顺序的，不能随意改动，否则可能会报错-->
<configuration>
    <settings>
        <!--开启驼峰命名-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <!--开启懒加载-->
        <setting name="lazyLoadingEnabled" value="true"/>
        <setting name="aggressiveLazyLoading" value="false"/>
        <!--开启二级缓存-->
        <setting name="cacheEnabled" value="true"/>
    </settings>
    <!--
    databaseIdProvider:用来支持多数据库厂商，type="DB_VENDOR":VendorDatabaseIdProvider
    作用就是得到数据库厂商的标识getDatabaseProductName()
    name是数据库厂商的标识，value使我们给他取的值
    -->
    <databaseIdProvider type="DB_VENDOR">
        <property name="MySQL" value="mysql"/>
        <property name="Oracle" value="oracle"/>
    </databaseIdProvider>
</configuration>
```