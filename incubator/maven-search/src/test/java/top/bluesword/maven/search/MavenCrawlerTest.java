package top.bluesword.maven.search;

import org.junit.jupiter.api.Test;
import top.bluesword.maven.domain.Dependency;

import java.io.IOException;

class MavenCrawlerTest {

    @Test
    void get() throws IOException {
        String repositoryUrlStr = "https://repo1.maven.org/maven2/";
        MavenCrawler mavenCrawler = new MavenCrawler(repositoryUrlStr);
        Dependency okhttp = Dependency.builder().groupId("org.jsoup").artifactId("jsoup").build();
        System.out.println(mavenCrawler.getLatest(okhttp));
    }
}