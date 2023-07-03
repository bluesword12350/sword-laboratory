package top.bluesword.laboratory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Repository;

import java.util.Locale;
import java.util.Optional;

/**
 * @author 李林峰
 */
@Mapper
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

    Optional<Locale> selectLocale(@Param("locale") Locale locale);

}