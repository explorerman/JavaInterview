常用命令：find ps grep awk mkdir rm cp touch stat 

## find

## grep

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