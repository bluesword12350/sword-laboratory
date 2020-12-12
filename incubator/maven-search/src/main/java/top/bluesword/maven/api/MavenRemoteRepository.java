package top.bluesword.maven.api;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import top.bluesword.maven.domain.Pack;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @author 李林峰
 */
public class MavenRemoteRepository {

    private final OkHttpClient httpClient = new OkHttpClient.Builder().build();

    private final HttpUrl repositoryUrl;

    public MavenRemoteRepository(String repositoryUrlStr) {
        this.repositoryUrl = HttpUrl.get(repositoryUrlStr);
    }

    public PackMetadata getPackMetadata(Pack pack) throws IOException, JAXBException {
        HttpUrl url = this.repositoryUrl.newBuilder()
                .addPathSegment(pack.getGroupPath())
                .addPathSegment(pack.getArtifactId())
                .addPathSegment("maven-metadata.xml")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            assert response.body() != null;
            return (PackMetadata) JAXBContext.newInstance(PackMetadata.class)
                    .createUnmarshaller()
                    .unmarshal(response.body().charStream());
        }
    }

    public String getPom(Pack pack) throws IOException {
        HttpUrl url = this.repositoryUrl.newBuilder()
                .addPathSegment(pack.getGroupPath())
                .addPathSegment(pack.getArtifactId())
                .addPathSegment(pack.getVersion())
                .addPathSegment(pack.getArtifactId()+"-"+pack.getVersion()+".pom")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }

}
