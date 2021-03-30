package top.bluesword.laboratory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class HoldFund {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static FundMap fundMap;

    public static void main(String[] args) throws IOException {
        holdFund();
    }

    private static void holdFund() throws IOException {
        fundMap = getHoldFunds();
        EastmoneyClient.searchYields(fundMap);
        List<Fund> funds = sortFunds();
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        FundHtmlWriter.write(funds,date + "持有基金近三年收益率报告",true);
    }

    private static List<Fund> sortFunds() {
        return fundMap.values().stream()
                .sorted(Fund.YIELD_COMPARATOR.reversed())
                .collect(Collectors.toList());
    }

    private static FundMap getHoldFunds() throws IOException {
        FundMap fundMap = new FundMap();
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
                fundMap.put(code,fund);
            }
        }
        return fundMap;
    }

}
