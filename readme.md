# 关于通关大boss作业的使用说明

## 1 buyer和seller登录系统：

 - 买家登录系统的地址为：http://localhost:8080/get/sessions/new , 买家用户名为：buyer， 密码为：reyub
 - 卖家登录系统的地址为：http://localhost:8080/get/sessions/seller/news 卖家用户名：seller， 密码为：relles

## 2 系统部署说明：
### 2.1 web 项目部署
- 本系统框架使用**springboot**进行开发，请按照springboot项目进行部署；
### 2.2 数据库部署
- 请先将netease-shopping.sql文件导入mysql数据库,其中已经包含数据库表结构和某些测试数据;
- 本系统配置的数据库默认用户名：root，密码: root；如需修改，请进入application-dev.yml配置文件进行修改;
### 2.3 图片上传路径设置
- 本系统默认的图片上传路径为**F:/image/**，如需修改，请进入**application-dev.yml**配置文件，修改 **web: upload-path:** 路径即可。

## 3 注意事项：
- 项目运行时，请务必联网，因为本系统使用的jquery路径是网络url；
