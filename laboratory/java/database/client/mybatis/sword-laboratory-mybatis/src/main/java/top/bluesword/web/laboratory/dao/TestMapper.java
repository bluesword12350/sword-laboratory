package top.bluesword.web.laboratory.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
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

    /**
     * 查询数字列表
     * @return 数字列表
     */
    Cursor<Integer> scan();

}