package top.bluesword.fund.io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import top.bluesword.fund.FundClient;
import top.bluesword.fund.fund.Fund;
import top.bluesword.fund.fund.FundMap;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class EastmoneyFundClient implements FundClient {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    @Override
    public void searchYields(FundMap fundMap) throws IOException {
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

    private void getYields(FundMap fundMap) throws IOException {
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
                    String yieldStr = fundInfos[10].replace("%", "");
                    if (StringUtils.isBlank(yieldStr)) {
                        continue;
                    }
                    fundMap.get(fundInfos[0]).setYield(new BigDecimal(yieldStr));
                }
            }
        }
    }

    @Override
    public FundMap searchFundRanking(LocalDate startDate,LocalDate endDate) throws IOException {
        FundMap fundMap = new FundMap();
        HttpUrl url =
                HttpUrl.get("http://fund.eastmoney.com/data/rankhandler.aspx")
                        .newBuilder()
                        .addQueryParameter("op","dy")
                        .addQueryParameter("sc", "qjzf")
                        .addQueryParameter("st","desc")
                        .addQueryParameter("sd",startDate.toString())
                        .addQueryParameter("ed",endDate.toString())
                        .addQueryParameter("pi","1")
                        .addQueryParameter("pn","1000")
                        .build();
        Request request = new Request.Builder().url(url)
                .header("Referer","http://fund.eastmoney.com")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        try(response) {
            String body = Objects.requireNonNull(response.body()).string();
            body = body.substring(15,body.length()-1);
            JSONArray funds = JSON.parseObject(body).getJSONArray("datas");
            for (int i = 0; i < funds.size(); i++) {
                String[] fundInfos = funds.getString(i).split(",");
                Fund fund = new Fund(fundInfos[0],fundInfos[1],new BigDecimal(fundInfos[3]));
                fundMap.add(fund);
            }
        }
        return fundMap;
    }
}
