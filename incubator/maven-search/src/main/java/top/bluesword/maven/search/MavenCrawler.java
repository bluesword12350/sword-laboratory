package top.bluesword.maven.search;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import top.bluesword.maven.domain.Dependency;

import java.io.IOException;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class MavenCrawler {

    private final OkHttpClient httpClient = new OkHttpClient.Builder().build();

    private final HttpUrl repositoryUrl;

    public MavenCrawler(String repositoryUrlStr,Dependency dependency) {
        this.repositoryUrl = HttpUrl.get(repositoryUrlStr);
    }

    private String getLatest(Dependency dependency) throws IOException {
        HttpUrl url = this.repositoryUrl.newBuilder()
                .addPathSegment(dependency.getGroupId())
                .addPathSegment(dependency.getArtifactId())
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            //todo 处理结果
            return null;
        }
    }

    public void get(Dependency dependency) throws IOException {
        String version = dependency.getVersion();
        if (Objects.isNull(version) || version.isBlank()) {
            version = getLatest(dependency);
        }
        HttpUrl url = this.repositoryUrl.newBuilder()
                .addPathSegment(dependency.getGroupId())
                .addPathSegment(dependency.getArtifactId())
                .addPathSegment(version)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            //todo 处理结果
        }
    }

}
