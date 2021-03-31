package top.bluesword.fund;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import top.bluesword.fund.fund.Fund;
import top.bluesword.fund.fund.FundMap;

import java.io.IOException;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class VikaHoldFundClient implements HoldFundClient {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    @Override
    public FundMap getHoldFunds() throws IOException {
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
