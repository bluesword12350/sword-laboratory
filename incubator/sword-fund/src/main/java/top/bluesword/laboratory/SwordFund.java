package top.bluesword.laboratory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class SwordFund {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static Map<String,Fund> fundMap;
    private static final YieldComparator YIELD_COMPARATOR = new YieldComparator();
    private static final int TARGET_NUMBER = 15;

    public static void main(String[] args) throws IOException {
        fundMap = getFunds();
        searchYields();
        List<Fund> funds = sortFunds();
        List<Fund> sellFunds = getSellFunds(funds);
        for (Fund sellFund : sellFunds) {
            System.out.println(sellFund);
        }
    }

    private static List<Fund> getSellFunds(List<Fund> funds) {
        if (funds.size()<TARGET_NUMBER) {
            return new ArrayList<>();
        }
        List<Fund> sellFunds = new ArrayList<>();
        for (int i = TARGET_NUMBER; i < funds.size(); i++) {
            Fund fund = funds.get(i);
            if (Instant.now().compareTo(fund.getSellTime()) > 0) {
                sellFunds.add(fund);
            }
        }
        return sellFunds;
    }

    private static List<Fund> sortFunds() {
        return fundMap.values().stream()
                .filter(x -> Objects.nonNull(x.getYield()))
                .sorted(YIELD_COMPARATOR)
                .collect(Collectors.toList());
    }

    private static void searchYields() throws IOException {
        List<String> fundCodes = new ArrayList<>();
        for (String code : fundMap.keySet()) {
            fundCodes.add(code);
            if (fundCodes.size() == 10) {
                getYields(fundCodes);
                fundCodes = new ArrayList<>();
            }
        }
        getYields(fundCodes);
    }

    private static void getYields(List<String> fundCodes) throws IOException {
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

    private static Map<String,Fund> getFunds() throws IOException {
        Map<String,Fund> fundSet = new HashMap<>(50);
        Request request =
                new Request.Builder()
                        .url("https://api.vika.cn/fusion/v1/datasheets/dsto5X91Hd2J4XavQS/records?viewId=viwlJBqyfTwxb&fieldKey=name")
                        .header("Authorization","Bearer uskEFgxQSzREdYd5gQwKsgs")
                        .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        try(response) {
            String string = Objects.requireNonNull(response.body()).string();
            JSONArray records = JSON.parseObject(string).getJSONObject("data").getJSONArray("records");
            for (int i = 0; i < records.size(); i++) {
                JSONObject fields = records.getJSONObject(i).getJSONObject("fields");
                String code = fields.getString("基金编码");
                Fund fund = new Fund(code, fields.getString("基金名称"), fields.getLong("可卖时间"));
                fundSet.put(code,fund);
            }
        }
        return fundSet;
    }

}
