1. 如果Mac下终端中使用mysql命令又报：command no find错误，则先source ~/.bash_profile ,如果不行，则 source ~/.zshrc
   [命令报错时的解决方法](https://baijiahao.baidu.com/s?id=1663734534335365714&wfr=spider&for=pc)

2. [MySQL忘记密码后如何修改](https://www.jb51.net/article/105486.htm)
   [修改密码参考，安全模式登陆后，直接修改user表的密码](https://www.linuxidc.com/Linux/2018-05/152575.htm)

   基本策略也是：关闭服务后，用安全模式启动（不用输密码），进入后update用户表，修改root即可