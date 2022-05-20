package top.bluesword.laboratory.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

/**
 * @author 李林峰
 */
public class FormSupportConfig {

    @Bean
    public Encoder formEncoder(ObjectFactory<HttpMessageConverters> messageConverters){
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

}
