package top.bluesword.com.fasterxml.jackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author 李林峰
 */
public class NoDecimalNumberSerialize extends JsonSerializer<BigDecimal> {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#");

    @Override
    public void serialize(BigDecimal number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(DECIMAL_FORMAT.format(number));
    }

}
