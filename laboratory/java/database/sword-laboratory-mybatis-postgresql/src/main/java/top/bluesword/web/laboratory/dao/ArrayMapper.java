package top.bluesword.web.laboratory.dao;

import org.springframework.stereotype.Repository;
import top.bluesword.web.laboratory.model.ArrayTestModel;

@Repository
public interface ArrayMapper {
    ArrayTestModel selectArray();
}