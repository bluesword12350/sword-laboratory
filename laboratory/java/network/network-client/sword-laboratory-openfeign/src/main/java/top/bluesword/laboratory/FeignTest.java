package top.bluesword.laboratory;

import feign.*;
import feign.gson.GsonDecoder;

import java.util.List;
import java.util.Objects;

interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}

class Contributor {
    String login;
    int contributions;
}

/**
 * @author 李林峰
 */
public class FeignTest {
    public static void main(String... args) {
        GitHub github = Feign.builder()
                .decoder(new GsonDecoder())
                .logLevel(Logger.Level.FULL)
                .target(GitHub.class, "https://api.github.com");
        try {
            List<Contributor> contributors = github.contributors("OpenFeign", "feign");
            for (Contributor contributor : contributors) {
                System.out.println(contributor.login + " (" + contributor.contributions + ")");
            }
        }catch (FeignException e){
            System.out.println(e.status());
            System.out.println(e.getMessage());
            byte[] content = e.content();
            if (Objects.nonNull(content)){
                System.out.println(new String(content));
            }
        }
    }
}
