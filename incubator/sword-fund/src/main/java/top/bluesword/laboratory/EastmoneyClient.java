package top.bluesword.laboratory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class EastmoneyClient {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    public static void searchYields(Map<String,Fund> fundMap) throws IOException {
        List<String> fundCodes = new ArrayList<>();
        for (String code : fundMap.keySet()) {
            fundCodes.add(code);
            if (fundCodes.size() == 10) {
                getYields(fundCodes,fundMap);
                fundCodes = new ArrayList<>();
            }
        }
        getYields(fundCodes,fundMap);
    }

    private static void getYields(List<String> fundCodes,Map<String,Fund> fundMap) throws IOException {
        HttpUrl url =
                HttpUrl.get("http://fund.eastmoney.com/Data/FundCompare_Interface.aspx")
                        .newBuilder()
                        .addQueryParameter("t","1")
                        .addQueryParameter("v", String.valueOf(Instant.now().toEpochMilli()))
                        .addQueryParameter("bzdm",String.join(",", fundCodes))
                        .build();
        Request request = new Request.Builder().url(url).build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        try(response) {
            String body = Objects.requireNonNull(response.body()).string();
            body = body.substring(20,body.length()-1);
            JSONArray jdsy = JSON.parseObject(body).getJSONArray("jdsy");
            for (int i = 0; i < jdsy.size(); i++) {
                String[] fundInfos = jdsy.getString(i).split(",");
                if (fundInfos.length > 10) {
                    fundMap.get(fundInfos[0]).setYieldStr(fundInfos[10]);
                }
            }
        }
    }

}
