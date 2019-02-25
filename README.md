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
    <ehcache.version>2.10.6</ehcache.version>
    <mybatis.ehcache.version>1.1.0</mybatis.ehcache.version>
</properties>

<dependencies>
    <!--mybatis-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>${mybatis.spring.version}</version>
    </dependency>
    <!--mybatis ehcache-->
    <dependency>
        <groupId>net.sf.ehcache</groupId>
        <artifactId>ehcache</artifactId>
        <version>${ehcache.version}</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis.caches</groupId>
        <artifactId>mybatis-ehcache</artifactId>
        <version>${mybatis.ehcache.version}</version>
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

## ehcache.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<ehcache>
    <!--
        缓存配置
           diskStore：指定数据在磁盘中的存储位置。
           name:缓存名称。
           defaultCache：当借助CacheManager.add("demoCache")创建Cache时，EhCache便会采用<defalutCache/>指定的的管理策略
           maxElementsInMemory：缓存最大个数。
           eternal:对象是否永久有效，一但设置了，timeout将不起作用。
           timeToIdleSeconds：设置对象在失效前的允许闲置时间（单位：秒）。
           仅当eternal=false对象不是永久有效时使用，可选属性，默认值是0，也就是可闲置时间无穷大。
           timeToLiveSeconds：设置对象在失效前允许存活时间（单位：秒）。最大时间介于创建时间和失效时间之间。
           仅当eternal=false对象不是永久有效时使用，默认是0.，也就是对象存活时间无穷大。
           overflowToDisk：当内存中对象数量达到maxElementsInMemory时，Ehcache将会对象写到磁盘中。
           diskSpoolBufferSizeMB：这个参数设置DiskStore（磁盘缓存）的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区。
           maxElementsOnDisk：硬盘最大缓存个数。
           diskPersistent：是否缓存虚拟机重启期数据，默认false.
           diskExpiryThreadIntervalSeconds：磁盘失效线程运行时间间隔，默认是120秒。
           memoryStoreEvictionPolicy：当达到maxElementsInMemory限制时，Ehcache将会根据指定的策略去清理内存。
           默认策略是LRU（最近最少使用）。你可以设置为FIFO（先进先出）或是LFU（较少使用）。
           clearOnFlush：内存数量最大时是否清除。
           copyOnRead：从缓存中读取数据时时返回对象引用还是复制一个对象返回，默认false，即返回引用，这种情况下都是相同对象。
           copyOnWrite：判断写入缓存时是直接缓存对象引用还是复制一个对象后缓存，默认false。
    -->
    <diskStore path="e:\ehcache"/>
    <defaultCache
            maxElementsInMemory="10000"
            eternal="false"
            timeToIdleSeconds="120"
            timeToLiveSeconds="120"
            overflowToDisk="true"
            maxElementsOnDisk="10000000"
            diskPersistent="false"
            diskExpiryThreadIntervalSeconds="120"
            memoryStoreEvictionPolicy="LRU"
            copyOnRead="true"
            copyOnWrite="true"
    />
</ehcache>
```