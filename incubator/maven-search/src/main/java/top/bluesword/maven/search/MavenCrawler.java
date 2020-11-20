package top.bluesword.maven.search;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import top.bluesword.maven.domain.Dependency;
import top.bluesword.maven.domain.Version;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class MavenCrawler {

    private final OkHttpClient httpClient = new OkHttpClient.Builder().build();

    private final HttpUrl repositoryUrl;

    public MavenCrawler(String repositoryUrlStr) {
        this.repositoryUrl = HttpUrl.get(repositoryUrlStr);
    }

    public String getLatest(Dependency dependency) throws IOException {
        HttpUrl url = this.repositoryUrl.newBuilder()
                .addPathSegment(dependency.getGroupPath())
                .addPathSegment(dependency.getArtifactId())
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            assert response.body() != null;
            Elements elements = Jsoup.parse(response.body().string()).select("a");
            String latestVersion = null;
            for (Element element : elements) {
                String text = element.text();
                if (text.startsWith(".") || !text.endsWith("/")) {
                    continue;
                }
                String version = text.substring(0,text.length()-1);
                latestVersion = Objects.isNull(latestVersion) ? version : Version.max(latestVersion, version);
            }
            return latestVersion;
        }
    }

    public void get(Dependency dependency) throws IOException {
        HttpUrl url = this.repositoryUrl.newBuilder()
                .addPathSegment(dependency.getGroupPath())
                .addPathSegment(dependency.getArtifactId())
                .addPathSegment(dependency.getVersion())
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            //todo 处理结果
        }
    }

    @Deprecated
    private static void outPutFile(String body, String pathUrl) throws IOException {
        String uuid = String.valueOf(System.currentTimeMillis());
        Path path = Paths.get(pathUrl);
        Files.write(path.resolve(uuid+".html"), body.getBytes());
    }
}
