# gmall

gmall谷粒商城开发
2019年6月26日 完成项目架构搭建
统一管理项目版本：
    gmall-parent工程：

公共代码抽取（普通maven工程）：
    gmall-api工程：
        继承gmall-parent工程
        引入mapper依赖
        抽取公共的bean和Service接口
    gmall-common-util工程：
        继承gmall-parent工程
        依赖：spring-boot-starter-test/web/dubbo、httpclient、
        commons-lang3/beanutils/codec、dubbo、zkclient、slf4j-log4j12
    gmall-web-util工程：
        继承gmall-parent工程
        依赖gmall-common-util工程
        依赖：thymeleaf
    gmall-service-util工程：
        继承gmall-parent工程
        依赖gmall-common-util工程
        依赖：spring-boot-starter-jdbc、mybatis-spring-boot-starter、
        mysql-connector-java、jedis

provider服务（Service层）：spring boot应用
    gmall-ums-service工程（8070）：提供ums的增删改查服务
        包名：com.atguigu.gmall.ums.*
        依赖：继承gmall-parent工程；依赖gmall-api和gmall-service-util工程
        配置：mysql数据源、mybatis、dubbo+zookeeper、log日志
        代码：mapper、service.impl
    
consumer服务应用（web层）：spring boot应用
    gmall-ums-web工程（8080）：提供ums的controller暴露接口服务
        包名：com.atguigu.gmall.ums.*
        依赖：继承gmall-parent工程；依赖gmall-api和gmall-web-util工程
        配置：dubbo+zookeeper
        代码：controller（映射请求url，通过dubbo远程调用gmall-ums-service的service接口处理具体业务，
        并返回结果数据）
    gmall-manage-web工程（8081）：提供统一的后端服务接口，统一处理前端发送的请求url，并返回数据
        包名：com.atguigu.gmall.manage.*
        依赖：继承gmall-parent工程；依赖gmall-api和gmall-web-util工程
        配置：dubbo+zookeeper

服务端口号管理：
    8080-8089 业务Service层（provider）端口范围
    8070-8079 前端控制web层（consumer）端口范围

2019年6月27日  实现平台属性和商品属性spu的查询、添加功能
