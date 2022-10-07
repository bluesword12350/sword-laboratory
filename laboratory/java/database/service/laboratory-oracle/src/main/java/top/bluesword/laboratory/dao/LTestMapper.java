package top.bluesword.laboratory.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import top.bluesword.laboratory.entity.LTest;

import java.util.List;

/**
 * @author 李林峰
 */
@Repository
public interface LTestMapper extends Mapper<LTest> {

    /**
     * 批量插入数据
     * @param list 新增列表
     * @return 修改数据行数
     */
    int insertList(List<LTest> list);

    /**
     * 查询测试值（注解实现）
     * @return 测试值列表
     */
    @Select("SELECT TEST_VALUE FROM L_TEST")
    List<String> selectValueList();

    /**
     * 通过测试值列表查询
     * @param values 测试值列表
     * @return 测试数据列表
     */
    List<LTest> selectListByValues(List<String> values);
}