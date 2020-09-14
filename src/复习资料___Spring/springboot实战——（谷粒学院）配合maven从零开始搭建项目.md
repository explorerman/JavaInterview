## maven的pom.xml的各种标签详细解释

详细解释都放在 https://gitee.com/JIEE_Shine/guli_parent.git项目中

注意：**classifier**这个属性很少用，所以没在上述项目中总结，如有碰到需要，则参考下面的文章链接

[pom文件各种配置参考链接](https://blog.csdn.net/qq_33363618/article/details/79438044)

[pom配置参考链接](https://www.cnblogs.com/zhoudaxing/p/11338183.html)

## 谷粒学院代码结构图



![image-20200908081723251](springboot%E5%AE%9E%E6%88%98%E2%80%94%E2%80%94%E9%85%8D%E5%90%88maven%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B%E6%90%AD%E5%BB%BA%E9%A1%B9%E7%9B%AE.assets/image-20200908081723251.png)

**guli-parent**:在线教学根目录(父工程)，管理四个子模块:

​	**canal-client**:**canal**数据库表同步模块(统计同步数据)

​	**common**:公共模块父节点 common-util:工具类模块，所有模块都可以依赖于它

​	service-base:service服务的base包，包含service服务的公共配置类，所有service模块依赖于它 spring-security:认证与授权模块，需要认证授权的service服务依赖于它

​	**infrastructure**:基础服务模块父节点 api-gateway:api网关服务

​	**service**:**api**接口服务父节点 

​	service-acl:用户权限管理api接口服务(用户管理、角色管理和权限管理等)

​	service-cms:cms api接口服务 

​	service-edu:教学相关api接口服务 

​	service-msm:短信api接口服务 

​	service-order:订单相关api接口服务 

​	service-oss:阿里云oss api接口服务 

​	service-statistics:统计报表api接口服务 

​	service-ucenter:会员api接口服务 

​	service-vod:视频点播api接口服务

## springboot注解

[Springboot2.2.1注解大全](https://www.imooc.com/article/290348)