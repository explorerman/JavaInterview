

在Linux下可以使用**yum**或者**apt-get**安装软件包

在Mac上安装软件，使用**Homebrew**

## Homebrew

Homebrew会将软件包安装到独立目录，并将其文件软链接至/usr/local，总之一点就是Homebrew会将安装的软件包统一进行管理，不用担心其存储位置等，安装好之后就可以用了。

homebrew可以理解为osx的软件管理工具，粗俗点就是Mac界的qq软件助手之类的工具，可以通过`brew`，安装什么chrome浏览器，atom编辑器之类的可视化工具。
npm是node.js界的程序/模块管理工具，也就是说npm只管理那些服务于JavaScript社区的程序，而且跨平台，Windows和osx,以及其他unix操作系统都可以用。

### 安装

首先来安装 Homebrew，将下面命令粘贴至终端执行即可。

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

### 使用

提示，以下命令均以 `Nginx` 为例，如需使用，将命令中的 `nginx` 替换为要操作的软件包名称即可。

#### 安装软件

例如我们要安装 `Nginx`，在下面终端输入以下命令即可。

```
brew install nginx
```

#### 卸载软件

```
brew uninstall nginx
```

#### 查看软件信息

```
brew info nginx
```

#### 查看已安装的软件

```
brew list
```

#### 替换源

由于国内网络环境问题，使用 brew 安装软件的时候，可能会失败，这个时候可以考虑将安装源替换为中科大的镜像，命令如下：

```
cd "$(brew --repo)"
git remote set-url origin https://mirrors.ustc.edu.cn/brew.git
```

如果想恢复为官方源，命令如下：

```
cd "$(brew --repo)"
git remote set-url origin https://github.com/Homebrew/brew.git
```

#### 更多用法

更多用法可以参考官方文档：「[Homebrew Documentation](https://docs.brew.sh/Manpage)」

Homebrew 还有个兄弟叫 「**Homebrew Cask**」，是专门安装图形化软件的工具，有兴趣的可以访问「[Homebrew Cask](https://github.com/Homebrew/homebrew-cask)」了解。

### 注意事项

我个人在 macOS 安装 `node` 的时候，最开始是使用的官方安装包进行安装的，后来在 `vue` 项目中执行 `npm install` 的时候总是出错，提示权限不足的问题。

后来，我把之前的 node 卸载了，使用 `brew install node`，自此之后，再使用 npm 相关命令就没出过错了。

所以，推荐使用 **brew** 安装 `node`，除此之外，包含但不限于 `python`、`nginx`、`maven` 等均推荐使用 **brew** 进行安装。

## iTerm使用

- 打开文件：open xxx
- 

## 参考链接

[iTerm2使用教程](https://www.jianshu.com/p/1fa9dc22f633)

[Alfred使用教程](https://www.jianshu.com/p/cf16b2c973e9)

[Mac下的神器](https://blog.csdn.net/github_33304260/article/details/87898489)

