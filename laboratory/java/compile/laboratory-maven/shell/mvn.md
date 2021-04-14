#该命令可以列出项目依赖的所有jar包，-Dverbose参数会把被忽略的jar，即相同jar包的不同版本引入也列出来。
```shell
mvn dependency:list -Dverbose
```

#列出项目的包依赖树
```shell
mvn dependency:tree [-Dverbose] [-Dincludes=[groupId]:[artifactId]:[type]:[version]] [-Dexcludes]
```

#分析依赖
```shell
mvn dependency:analyze-only
```
dependency:analyze-only命令可以分析整个项目，并且找出项目中依赖有如下情况的：
声明了并且使用了的依赖
没有声明但是使用了的依赖
声明了但是没有使用的依赖
需要注意的是，如果你要查看声明了并且使用了的依赖，必须加上参数-Dverbose。

```shell
mvn dependency:analyze-duplicate
```
这个命令会查找<dependencies/> 和 <dependencyManagement/>中重复声明的依赖

