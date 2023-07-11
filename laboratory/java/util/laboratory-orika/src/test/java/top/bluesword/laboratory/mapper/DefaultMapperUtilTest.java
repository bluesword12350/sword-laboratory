package top.bluesword.laboratory.mapper;

import org.junit.jupiter.api.Test;
import top.bluesword.laboratory.domain.DataModel;
import top.bluesword.laboratory.transfer.BaseDataDTO;
import top.bluesword.laboratory.transfer.DataModelDTO;

class DefaultMapperUtilTest {

    @Test
    void map(){
        BaseDataDTO baseDataDTO = buildBaseData();
        DataModel dataModel = DefaultMapperUtil.map(baseDataDTO, DataModel.class);
        String key = dataModel.getKey();
        System.out.println(key);
    }

    private BaseDataDTO buildBaseData() {
        DataModelDTO dataModelDTO = new DataModelDTO();
        dataModelDTO.setKey("父类映射");
        return dataModelDTO;
    }

    @Test
    void mapNull(){
        BaseDataDTO baseDataDTO = null;
        DataModel dataModel = DefaultMapperUtil.map(baseDataDTO, DataModel.class);
        System.out.println(dataModel);
    }

}