# spring-cloud-dubbo
springcloud alibaba 集成 dubbo


# 安装nacos
## 下载地址
https://github.com/alibaba/nacos/releases/download/1.4.2/nacos-server-1.4.2.tar.gz
## 启动
单机模式启动
sh startup.sh -m standalone
## 访问
http://192.16.8.201:8848/nacos
账号密码都是nacos

# 聚合项目打包
## 默认打包
`mvn clean package`
## 指定profile打包
`mvn clean package -Pprod`
## 指定模块打包
`mvn clean package -pl provider-log -am -amd -Pprod`
## 参数介绍
>-am是引入指定模块的依赖也编译
>
>-amd是引入依赖的依赖也进行编译
> 
> -pl是指定打包module
> 
> -Pprod 是指定打包的id为prod的profile


# 网关问题
## 手动注入到nacos
需要注意如何获取ip地址
https://github.com/chywx/spring-boot-chy/tree/rigister-nacos/chy-socketio

# 版本对应关系
https://blog.csdn.net/weixin_43702146/article/details/127302612


# nacos
## 配置内容
项目目录的doc文件夹下
## 配置说明
https://blog.csdn.net/u014087208/article/details/108364510