package top.bluesword.laboratory.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @author 李林峰
 */
public class DefaultMapperUtil {

    private final static MapperFacade MAPPER_FACADE = new DefaultMapperFactory.Builder().build().getMapperFacade();

    public static <S, D> void map(S sourceObject, D destinationObject) {
        MAPPER_FACADE.map(sourceObject,destinationObject);
    }

    public static <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return MAPPER_FACADE.map(sourceObject,destinationClass);
    }

}
