package top.bluesword.laboratory.mapper;

import org.junit.jupiter.api.Test;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.transfer.BaseDataDTO;
import top.bluesword.laboratory.transfer.DataModelDTO;

class DataModelMapperTest {

    @Test
    void map(){
        DataModelDTO baseDataDTO = buildBaseData();
        DataModel dataModel = DataModelMapper.INSTANCE.dtoToDo(baseDataDTO);
        String key = dataModel.getKey();
        System.out.println(key);
    }

    private DataModelDTO buildBaseData() {
        DataModelDTO dataModelDTO = new DataModelDTO();
        dataModelDTO.setKey("父类映射");
        return dataModelDTO;
    }
}
