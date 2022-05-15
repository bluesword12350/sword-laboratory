import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inspiration {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL piUrl = ClassLoader.getSystemResource("PI.txt");
        assert piUrl != null;
        FileInputStream piInput = new FileInputStream(new File(piUrl.toURI()));
        String pi;
        try(piInput) {
            pi = new String(piInput.readAllBytes());
        }
        List<Map<String,Integer>> data = new ArrayList<>();
        for (int i = 0; i < 366; i++) {
            int num = Integer.parseInt(String.valueOf(pi.charAt(i)));
            Map<String,Integer> map = new HashMap<>();
            map.put("day",i+1);
            map.put("num",num);
            data.add(map);
        }
        System.out.println(new Gson().toJson(data));
    }
}
