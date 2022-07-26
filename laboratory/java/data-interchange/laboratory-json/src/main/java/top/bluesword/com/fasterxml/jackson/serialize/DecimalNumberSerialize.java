package top.bluesword.com.fasterxml.jackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author 李林峰
 */
public class DecimalNumberSerialize extends JsonSerializer<BigDecimal> {

    public static final DecimalNumberSerialize INSTANCE = new DecimalNumberSerialize();

    @Override
    public void serialize(BigDecimal number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(number.toPlainString());
    }

}
