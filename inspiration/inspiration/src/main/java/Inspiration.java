import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author 李林峰
 */
public class Inspiration {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL piUrl = ClassLoader.getSystemResource("PI.txt");
        assert piUrl != null;
        FileInputStream piInput = new FileInputStream(new File(piUrl.toURI()));
        String pi;
        try(piInput) {
            pi = new String(piInput.readAllBytes());
        }
        System.out.println(pi);
    }
}
