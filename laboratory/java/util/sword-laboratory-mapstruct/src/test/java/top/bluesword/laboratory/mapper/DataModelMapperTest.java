package top.bluesword.laboratory.mapper;

import org.junit.jupiter.api.Test;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.transfer.DataModelDTO;

class DataModelMapperTest {

    @Test
    void map(){
        DataModelDTO baseDataDTO = buildDataModelDTO();
        DataModel dataModel = DataModelMapper.INSTANCE.map(baseDataDTO);
        String key = dataModel.getKey();
        System.out.println(key);
    }

    private DataModelDTO buildDataModelDTO() {
        DataModelDTO dataModelDTO = new DataModelDTO();
        dataModelDTO.setKey("目标值");
        return dataModelDTO;
    }

}
