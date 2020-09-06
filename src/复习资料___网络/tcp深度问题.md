1. 三次握手一直失败怎么排查？

2. timewait出现的原因以及解决方法，以及这种方法会出现什么问题

3. 遇到rst,如何排查rst（connection reset, or rst标志位）

   - 服务没启动
   - 重启
   - iptables设置规则

4. rst标志位出现的几种实际情况和常见问题

5. reuseport和reuseaddr二者的区别
   reuseport支持完全的重复绑定

6. tcpdump
   tcpdump抓包时数据包可能比较长，-s可以设置多少字节
   xshell有时候包不全，可以-s0

7. 半连接，全连接（默认丢弃），满了怎么办
   syncookies开启，直接连

8. 繁忙服务器，如果服务端是阻塞套接字，那么在epoll返回和accept中间，有可能发rst包，那么该链接会从accept队列移走

9. Redis底层是ziplist和dict，这个ziplist是如何知道大小的

10. 互斥锁和条件变量的区别

11. 缓存一致性问题

    [群内大佬发的，没看，不造咋样](https://coolshell.cn/articles/17416.html)

    订阅binlog，同步缓存





