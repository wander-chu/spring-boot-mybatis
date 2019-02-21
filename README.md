# Spring Boot集成MyBatis,分页插件PageHelper,通用Mapper 

## 主要内容

    1.使用分页插件PageHelper实现MyBatis的物理分页
    2.通过通用Mapper提供的通用方法查询数据。
    3.通过xml和注解中编写sql的方式查询数据。
    4.一对一、一对多的关联关系查询数据。
    5.Controller的单元测试。


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

## application.properties 配置
```properties
# mybatis
mybatis.type-aliases-package=com.example.springbootmybatis.model
mybatis.mapper-locations=classpath:mapper/*.xml

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