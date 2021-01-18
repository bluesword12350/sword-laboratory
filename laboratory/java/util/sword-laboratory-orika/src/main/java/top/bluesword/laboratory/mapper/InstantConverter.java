package top.bluesword.laboratory.mapper;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.Instant;

/**
 * @author 李林峰
 */
public class InstantConverter extends BidirectionalConverter<Instant,Long> {

    @Override
    public Long convertTo(Instant source, Type<Long> destinationType, MappingContext mappingContext) {
        return source.toEpochMilli();
    }

    @Override
    public Instant convertFrom(Long source, Type<Instant> destinationType, MappingContext mappingContext) {
        return Instant.ofEpochMilli(source);
    }

}
