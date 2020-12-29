git log 查看历史记录

git reflog   reference log

git show 查看当前commit / git show id 查看id的commit

git diff 查看未提交的内容

git diff _--staged/cached 显示暂存区和上一条提交之间的不同

git rebase 目标基础点  在目标基础点上重新提交

git rebase -i 可以合并几个commit

git rebase --onto 在rebase命令中直接剔除想撤销的commits

git reset --hard HEAD^  撤销一条commit 不加hard也行

git stash 临时存放工作目录的改动

git stash -u 会将没有被track的文件（没有被add的文件）一起暂存 -u是--include-untracked的缩写

git stash pop恢复之前存储的内容

git commit

git commit --amend

git branch feature1 

git branch -d feature1 

git checkout feature1

git checkout -b feature1

git push

git push origin bracnch1 -f 忽悠冲突，强制push

git revert HEAD^  撤销哪个commit

git merge branch1

git merge featrue1

git merge --abort

git pull

git status

git add . 直接把工作目录下的所有改动全部放进暂存区。

.gitignore 忽悠文件

忽悠文件内容：*.apk