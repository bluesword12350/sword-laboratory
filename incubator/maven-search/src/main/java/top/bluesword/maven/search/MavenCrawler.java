package top.bluesword.maven.search;

import top.bluesword.maven.domain.Pack;

/**
 * @author 李林峰
 */
public class MavenCrawler {

    public void crawl(Pack pack) {
        //todo 判断是否强制分析，否则判断是否分析过，分析过则跳过；是，则删除已分析的依赖关系网
        //todo 获取软件包的pom
        //todo 解析pom获取依赖的软件包列表
        //todo 将软件包列表依赖关系保存到数据库
        //todo 将软件包列表保存到数据库
        //todo 将软件包列表添加到任务列表提交给爬虫引擎继续运行
    }
}
