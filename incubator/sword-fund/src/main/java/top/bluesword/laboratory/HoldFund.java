package top.bluesword.laboratory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class HoldFund {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static Map<String,Fund> fundMap;
    private static final Fund.YieldComparator YIELD_COMPARATOR = new Fund.YieldComparator();

    public static void main(String[] args) throws IOException {
        holdFund();
    }

    private static void holdFund() throws IOException {
        fundMap = getHoldFunds();
        EastmoneyClient.searchYields(fundMap);
        List<Fund> funds = sortFunds();
        outPut(funds);
    }

    private static void outPut(List<Fund> funds) throws IOException {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheTTLMs(3600000L);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariable("funds",funds);
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
        templateEngine.process("fund.html", context,new FileWriter(date+"持有基金报告.html"));
    }

    private static List<Fund> sortFunds() {
        return fundMap.values().stream()
                .sorted(YIELD_COMPARATOR.reversed())
                .collect(Collectors.toList());
    }

    private static Map<String,Fund> getHoldFunds() throws IOException {
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