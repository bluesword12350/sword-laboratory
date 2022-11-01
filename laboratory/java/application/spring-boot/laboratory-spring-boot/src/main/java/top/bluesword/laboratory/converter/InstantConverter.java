package top.bluesword.laboratory.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author 李林峰
 */
@Component
public class InstantConverter implements Converter<String, Instant> {

    @Override
    public Instant convert(String s) {
        if(StringUtils.isNumeric(s)) {
            return Instant.ofEpochMilli(Long.parseLong(s));
        }
        return Instant.parse(s);
    }

}
