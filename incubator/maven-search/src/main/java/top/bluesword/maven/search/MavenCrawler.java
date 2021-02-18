package top.bluesword.maven.search;

import top.bluesword.maven.api.MavenRemoteRepository;
import top.bluesword.maven.api.PomParser;
import top.bluesword.maven.domain.Pack;
import top.bluesword.maven.domain.Pom;

import java.io.IOException;
import java.util.List;

/**
 * @author 李林峰
 */
public class MavenCrawler {

    private final MavenRemoteRepository remoteRepository;

    public MavenCrawler(String repositoryUrlStr) {
        this.remoteRepository = new MavenRemoteRepository(repositoryUrlStr);
    }

    public void crawl(Pack pack) throws IOException {
        //todo 删除已分析的依赖关系网
        String pomXml = remoteRepository.getPom(pack);
        Pom pom = PomParser.parse(pomXml);
        List<Pack> dependencies = pom.getDependencies();
        //todo 将软件包列表依赖关系保存到数据库
        //todo 将软件包列表保存到数据库
        //todo 将软件包列表添加到任务列表提交给爬虫引擎继续运行
    }
}
