package top.bluesword.web.laboratory.dao;

import org.springframework.stereotype.Repository;
import top.bluesword.web.laboratory.model.ArrayTestModel;

import java.util.List;

/**
 * @author 李林峰
 */
@Repository
public interface ArrayMapper {

    /**
     * 查询数组
     * @return 数组
     */
    List<ArrayTestModel> selectArray();

}