package top.bluesword.laboratory.dao;

import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author 李林峰
 */
@Repository
public interface TestMapper {

    /**
     * 查询当前时间
     * @return 当前时间
     */
    Optional<String> selectNow();

}