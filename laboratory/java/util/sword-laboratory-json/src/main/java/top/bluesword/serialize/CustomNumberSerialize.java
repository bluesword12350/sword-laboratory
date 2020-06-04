package top.bluesword.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @author 李林峰
 */
public class CustomNumberSerialize extends JsonSerializer<Number> {

    private static final DecimalFormat DF = new DecimalFormat("#.0000");

    @Override
    public void serialize(Number number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(DF.format(number));
    }
}
