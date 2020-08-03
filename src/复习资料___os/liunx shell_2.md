常用命令：find ps grep awk mkdir rm cp touch stat 

## find

用于在文件树中查找文件，并作出相应的处理。

命令格式：

```shell
find pathname -options [-print -exec -ok ...]
```

命令参数：

```
pathname: find命令所查找的目录路径。例如用.来表示当前目录，用/来表示系统根目录。
-print： find命令将匹配的文件输出到标准输出。
-exec： find命令对匹配的文件执行该参数所给出的shell命令。相应命令的形式为'command' {  } \;，注意{   }和\；之间的空格。
-ok： 和-exec的作用相同，只不过以一种更为安全的模式来执行该参数所给出的shell命令，在执行每一个命令之前，都会给出提示，让用户来确定是否执行。
1234
```

**命令选项**：

```
-name 按照文件名查找文件
-perm 按文件权限查找文件
-user 按文件属主查找文件
-group  按照文件所属的组来查找文件。
-type  查找某一类型的文件，诸如：
   b - 块设备文件
   d - 目录
   c - 字符设备文件
   l - 符号链接文件
   p - 管道文件
   f - 普通文件
1234567891011
```

**实例**：

（1）查找 48 小时内修改过的文件

```shell
find -atime -2
```

（2）在当前目录查找 以 .log 结尾的文件。 **.** 代表当前目录

```shell
find ./ -name '*.log'
```

（3）查找 /opt 目录下 权限为 777 的文件

```shell
find /opt -perm 777
```

（4）查找大于 1K 的文件

```shell
find -size +1000c
```

查找等于 1000 字符的文件

```shell
find -size 1000c 
```

-exec 参数后面跟的是 command 命令，它的终止是以 ; 为结束标志的，所以这句命令后面的分号是不可缺少的，考虑到各个系统中分号会有不同的意义，所以前面加反斜杠。{} 花括号代表前面find查找出来的文件名。

## grep

强大的文本搜索命令，grep(Global Regular Expression Print) 全局正则表达式搜索。

grep 的工作方式是这样的，它在一个或多个文件中搜索字符串模板。如果模板包括空格，则必须被引用，模板后的所有字符串被看作文件名。搜索的结果被送到标准输出，不影响原文件内容。

命令格式：

```
grep [option] pattern file|dir
1
```

**常用参数**：

```
-A n --after-context显示匹配字符后n行
-B n --before-context显示匹配字符前n行
-C n --context 显示匹配字符前后n行
-c --count 计算符合样式的列数
-i 忽略大小写
-l 只列出文件内容符合指定的样式的文件名称
-f 从文件中读取关键词
-n 显示匹配内容的所在文件中行数
-R 递归查找文件夹
123456789
```

grep 的规则表达式:

```
^  #锚定行的开始 如：'^grep'匹配所有以grep开头的行。 
$  #锚定行的结束 如：'grep$'匹配所有以grep结尾的行。 
.  #匹配一个非换行符的字符 如：'gr.p'匹配gr后接一个任意字符，然后是p。  
*  #匹配零个或多个先前字符 如：'*grep'匹配所有一个或多个空格后紧跟grep的行。
.*   #一起用代表任意字符。  
[]   #匹配一个指定范围内的字符，如'[Gg]rep'匹配Grep和grep。 
[^]  #匹配一个不在指定范围内的字符，如：'[^A-FH-Z]rep'匹配不包含A-R和T-Z的一个字母开头，紧跟rep的行。  
\(..\)  #标记匹配字符，如'\(love\)'，love被标记为1。   
\<      #锚定单词的开始，如:'\<grep'匹配包含以grep开头的单词的行。
\>      #锚定单词的结束，如'grep\>'匹配包含以grep结尾的单词的行。
x\{m\}  #重复字符x，m次，如：'0\{5\}'匹配包含5个o的行。 
x\{m,\}  #重复字符x,至少m次，如：'o\{5,\}'匹配至少有5个o的行。  
x\{m,n\}  #重复字符x，至少m次，不多于n次，如：'o\{5,10\}'匹配5--10个o的行。  
\w    #匹配文字和数字字符，也就是[A-Za-z0-9]，如：'G\w*p'匹配以G后跟零个或多个文字或数字字符，然后是p。  
\W    #\w的反置形式，匹配一个或多个非单词字符，如点号句号等。  
\b    #单词锁定符，如: '\bgrep\b'只匹配grep。
12345678910111213141516
```

**实例**：

（1）查找指定进程

```shell
ps -ef | grep svn
```

（2）查找指定进程个数

```shell
ps -ef | grep svn -c
```

（3）从文件中读取关键词

```shell
cat test1.txt | grep -f key.log
```

（4）从文件夹中递归查找以grep开头的行，并只列出文件

```shell
grep -lR '^grep' /tmp
```

（5）查找非x开关的行内容

```shell
grep '^[^x]' test.txt
```

（6）显示包含 ed 或者 at 字符的内容行

```shell
grep -E 'ed|at' test.txt
```

## awk

awk,sed,grep三者适用的方向不同：

grep:更适合单纯的查找或匹配文本

sed:更适合编辑匹配到的文本

awk:更适合格式化文本，对文本进行复杂格式处理



- 新建文件/目录：mkdir xxx
- 删除文件：rm xxx.txt
- 删除目录：rm -r xxx
- 文件重命名：mv a b 将a文件改为b，可以先touch old.txt一个空文件文件，在mv，利用移动命令修改
- 复制某目录下文件：cp source dest  ： cp -r test/ newTest 将目录test/下的内容复制到newTest文件下

[常用Linux总结](https://blog.csdn.net/ThinkWon/article/details/104588679)