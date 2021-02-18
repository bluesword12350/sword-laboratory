package top.bluesword.maven.search;

import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;
import top.bluesword.maven.domain.Pack;

import java.io.IOException;

class MavenCrawlerTest {

    @Test
    void crawl() throws IOException, DocumentException {
        MavenCrawler mavenCrawler = new MavenCrawler("https://repo1.maven.org/maven2/");
        Pack sword = Pack.builder().groupId("top.bluesword").artifactId("sword").version("3.0.9").build();
        mavenCrawler.crawl(sword);
    }
}