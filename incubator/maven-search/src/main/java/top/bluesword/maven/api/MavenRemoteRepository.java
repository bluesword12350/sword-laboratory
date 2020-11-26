package top.bluesword.maven.api;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import top.bluesword.maven.domain.Pack;
import top.bluesword.maven.domain.VersionTextComparator;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 李林峰
 */
public class MavenRemoteRepository {

    private final OkHttpClient httpClient = new OkHttpClient.Builder().build();

    private final HttpUrl repositoryUrl;

    public MavenRemoteRepository(String repositoryUrlStr) {
        this.repositoryUrl = HttpUrl.get(repositoryUrlStr);
    }

    public Set<String> getVersions(Pack pack) throws IOException {
        HttpUrl url = this.repositoryUrl.newBuilder()
                .addPathSegment(pack.getGroupPath())
                .addPathSegment(pack.getArtifactId())
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            assert response.body() != null;
            Elements elements = Jsoup.parse(response.body().string()).select("a");
            Set<String> versionSet = new TreeSet<>(new VersionTextComparator().reversed());
            for (Element element : elements) {
                String text = element.text();
                if (text.startsWith(".") || !text.endsWith("/")) {
                    continue;
                }
                String version = text.substring(0,text.length()-1);
                versionSet.add(version);
            }
            return versionSet;
        }
    }

    public String getPom(Pack pack) throws IOException {
        //todo 获取POM文件内容
        return null;
    }
}
