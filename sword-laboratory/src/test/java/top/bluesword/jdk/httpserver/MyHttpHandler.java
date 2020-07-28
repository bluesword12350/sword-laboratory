package top.bluesword.jdk.httpserver;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) {
        try {
            String responseText =
                    "请求方法：" + httpExchange.getRequestMethod() + "<br/>" +
                    "请求参数：" + getRequestParam(httpExchange) + "<br/>" +
                    "请求头：<br/>" +
                    getRequestHeader(httpExchange);
            handleResponse(httpExchange, responseText);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取请求头
     */
    private String getRequestHeader(HttpExchange httpExchange) {
        Headers headers = httpExchange.getRequestHeaders();
        return headers.entrySet().stream()
                .map((Map.Entry<String, List<String>> entry) -> entry.getKey() + ":" + entry.getValue().toString())
                .collect(Collectors.joining("<br/>"));
    }

    /**
     * 获取请求参数
     */
    private String getRequestParam(HttpExchange httpExchange) throws Exception {
        String paramStr;
        if (httpExchange.getRequestMethod().equals("GET")) {
            paramStr = httpExchange.getRequestURI().getQuery();
        } else {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody(), StandardCharsets.UTF_8));
            StringBuilder requestBodyContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                requestBodyContent.append(line);
            }
            paramStr = requestBodyContent.toString();
        }

        return paramStr;
    }

    /**
     * 处理响应
     */
    private void handleResponse(HttpExchange httpExchange, String responseText) throws Exception {
        String responseContentStr = "<html>" +
                "<body>" +
                responseText +
                "</body>" +
                "</html>";
        byte[] responseContentByte = responseContentStr.getBytes(StandardCharsets.UTF_8);
        httpExchange.getResponseHeaders().add("Content-Type:", "text/html;charset=utf-8");
        httpExchange.sendResponseHeaders(200, responseContentByte.length);
        OutputStream out = httpExchange.getResponseBody();
        try (out) {
            out.write(responseContentByte);
        }
    }
}
