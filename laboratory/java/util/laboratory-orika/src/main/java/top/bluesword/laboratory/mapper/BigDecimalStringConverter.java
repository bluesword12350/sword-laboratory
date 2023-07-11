package top.bluesword.laboratory.mapper;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.math.BigDecimal;

/**
 * @author 李林峰
 */
public class BigDecimalStringConverter extends BidirectionalConverter<BigDecimal,String> {

    @Override
    public String convertTo(BigDecimal source, Type<String> destinationType, MappingContext mappingContext) {
        return source.toString();
    }

    @Override
    public BigDecimal convertFrom(String source, Type<BigDecimal> destinationType, MappingContext mappingContext) {
        return new BigDecimal(source);
    }

}
