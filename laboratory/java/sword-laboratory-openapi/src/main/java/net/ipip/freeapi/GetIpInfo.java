package net.ipip.freeapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import top.bluesword.util.network.HttpClientUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class GetIpInfo {

    private static final String URL = "http://freeapi.ipip.net/";

    private static final String[] keys = new String[]{"国家","省会","地区","单位","运营商","纬度"
            ,"经度","地理时区","自然时区","行政区划代码","国际电话代码","国家二位代码","世界大洲代码"};

    public static Map<String,String> getIpInfo(String ip){
        String result = HttpClientUtil.sendGet(URL + ip);
        final JSONArray ra = JSON.parseArray(result);
        Map<String,String> map = new LinkedHashMap<>();
        for (int i = 0; i < ra.size(); i++) {
            map.put(keys[i],ra.getString(i));
        }
        return map;
    }
}
