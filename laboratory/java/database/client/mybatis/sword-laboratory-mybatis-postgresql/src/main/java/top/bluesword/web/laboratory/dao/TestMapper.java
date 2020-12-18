package top.bluesword.web.laboratory.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author 李林峰
 */
@Repository
public interface TestMapper {

    /**
     * 查询N月前时间
     * @param month 月数
     * @return N月前时间
     */
    Optional<String> nMonthsAgo(@Param("month") int month);

}