package top.bluesword.laboratory.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @author 李林峰
 */
public class DefaultMapperUtil {

    private final static MapperFacade MAPPER_FACADE = build();

    private static MapperFacade build() {
        DefaultMapperFactory defaultMapperFactory = new DefaultMapperFactory.Builder().build();
        ConverterFactory converterFactory = defaultMapperFactory.getConverterFactory();
        converterFactory.registerConverter(new InstantConverter());
        converterFactory.registerConverter(new BigDecimalStringConverter());
        return defaultMapperFactory.getMapperFacade();
    }

    public static <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return MAPPER_FACADE.map(sourceObject,destinationClass);
    }

}
