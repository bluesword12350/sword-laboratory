package top.bluesword.laboratory.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.transfer.DataModelDTO;

/**
 * @author 李林峰
 */
@Mapper
public interface DataModelMapper {

    DataModelMapper INSTANCE = Mappers.getMapper(DataModelMapper.class);

    /**
     * 拷贝对象
     * @param dto 源数据
     * @return 拷贝目标
     */
    @Mappings({})
    DataModel dtoToDo(DataModelDTO dto);

}
