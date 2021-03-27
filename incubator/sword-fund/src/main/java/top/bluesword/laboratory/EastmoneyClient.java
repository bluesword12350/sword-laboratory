package top.bluesword.laboratory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class EastmoneyClient {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    public static void searchYields(FundMap fundMap) throws IOException {
        Collection<Fund> funds = fundMap.values();
        FundMap fundMapForYield = new FundMap();
        for (Fund fund : funds) {
            fundMapForYield.add(fund);
            if (fundMapForYield.size()==10) {
                getYields(fundMapForYield);
                fundMapForYield = new FundMap();
            }
        }
        getYields(fundMap);
    }

    private static void getYields(FundMap fundMap) throws IOException {
        List<String> fundCodes = fundMap.values().stream().map(Fund::getCode).collect(Collectors.toList());
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
