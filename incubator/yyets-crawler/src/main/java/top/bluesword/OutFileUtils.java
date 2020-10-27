package top.bluesword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OutFileUtils {

    public static void outPutFile(String headers,String body, String pathUrl) throws IOException {
        String uuid = String.valueOf(System.currentTimeMillis());
        Path path = Paths.get(pathUrl);
        Files.write(path.resolve(uuid+"-headers.txt"), headers.getBytes());
        Files.write(path.resolve(uuid+".html"), body.getBytes());
    }

}
