# Linux shell

find $IMG_DIR -name '*jpg' | awk '{print $1" "$1".json"}' > ${IMG_DIR}/../run_list

bash: bourne again shell 

## 文件管理

## 文档编辑

## 文件传输

## 磁盘管理

## 磁盘保护

## 网络通讯

## 系统管理

## 系统设置

##  备份压缩

## 设备管理

## 参考资料

`cd`:

- `.`表示当前目录
- `..` 表示当前目录的上一级目录（父目录）
- `-`表示用 cd 命令切换目录**前**所在的目录
- `~` 表示**用户主目录**的绝对路径名

`ls`：显示文件或目录信息

`mkdir`：当前目录下创建一个空目录

`rmdir`：要求目录为空

`touch`：生成一个空文件或更改文件的时间

`cp`：复制文件或目录

`mv`：移动文件或目录、文件或目录改名

`rm`：删除文件或目录

`ln`：建立链接文件

`find`：查找文件

`file/stat`：查看文件类型或文件属性信息

`cat：`查看文本文件内容

`more：`可以分页看

`less：`不仅可以分页，还可以方便地搜索，回翻等操作

`tail -10`： 查看文件的尾部的10行

`head -20`：查看文件的头部20行

`echo`：把内容重定向到指定的文件中 ，有则打开，无则创建

`管道命令 |` ：将前面的结果给后面的命令，例如：`ls -la | wc`，将ls的结果加到wc命令来统计字数

`重定向 > 是覆盖模式，>> 是追加模式`，例如：`echo "Java3y,zhen de hen xihuan ni" > qingshu.txt`把左边的输出放到右边的文件里去

[Linux命令大全](https://www.runoob.com/linux/linux-command-manual.html)

[Linux简介](https://www.zhihu.com/search?type=content&q=linux%20bash)