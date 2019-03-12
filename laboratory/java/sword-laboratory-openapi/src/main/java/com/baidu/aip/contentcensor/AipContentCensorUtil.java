package com.baidu.aip.contentcensor;

import org.json.JSONObject;

/**
 * 百度文本审核
 * @author 李林峰
 */
public class AipContentCensorUtil {

    static JSONObject antiSpam(String content){
        String appId = "11776022";
        String aipKey = "vCrrPLTByM27u3goYza3QM6G";
        String secretKey = "x8BNlOn2Ni4mW9WOqxdrbdrioTVvV7Kb";
        return new AipContentCensor(appId, aipKey, secretKey).antiSpam(content, null);
    }
}