package top.bluesword.web.laboratory.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 李林峰
 */
@Repository
public interface TestMapper {

    /**
     * 查询当前时间
     * @return 当前时间
     */
    @Select("select now()")
    String selectNow();
}