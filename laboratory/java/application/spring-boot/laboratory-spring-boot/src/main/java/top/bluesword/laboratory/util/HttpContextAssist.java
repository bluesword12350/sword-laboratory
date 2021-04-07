package top.bluesword.laboratory.util;

import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李林峰
 */
public class HttpContextAssist {

    public static String getLocaleCode() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getLocale().toString();
    }

    public static String getJsonBody() throws IOException {
        HttpServletRequest request = getHttpServletRequest();
        ServletServerHttpRequest inputMessage = new ServletServerHttpRequest(request);
        MediaType contentType = inputMessage.getHeaders().getContentType();
        if (!MediaType.APPLICATION_JSON.includes(contentType)) {
            return null;
        }
        InputStream inputStream = inputMessage.getBody();
        byte[] bytes = inputStream.readAllBytes();
        return new String(bytes);
    }

    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes requestContext = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        assert requestContext != null;
        return requestContext.getRequest();
    }

}
