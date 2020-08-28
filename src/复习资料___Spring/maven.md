淘淘商城：

taotao-parent的packaging是pom

使用maven install安装到本地

taotao-common的packaging是**jar**，在pom文件中增加parent，指向taotao-parent

修改完配置文件后 update Project Configuration

taotao-manager的packaging是**pom**,也修改pom文件，增加parent，指向taotao-parent

taotao-manager-web的packaging是war包