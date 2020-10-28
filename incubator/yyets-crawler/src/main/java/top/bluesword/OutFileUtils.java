package top.bluesword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 李林峰
 */
public class OutFileUtils {

    public static void outPutFile(String body, String pathUrl) throws IOException {
        String uuid = String.valueOf(System.currentTimeMillis());
        Path path = Paths.get(pathUrl);
        Files.write(path.resolve(uuid+".html"), body.getBytes());
    }

}
