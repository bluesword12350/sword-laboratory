package top.bluesword.web.laboratory.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class IntegerArrayTypeHandler extends BaseTypeHandler<Integer[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer[] integers, JdbcType jdbcType) throws SQLException {
        Connection conn = preparedStatement.getConnection();
        Array array = conn.createArrayOf(null, integers);
        preparedStatement.setArray(i, array);
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getArray(resultSet.getArray(s));
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getArray(resultSet.getArray(i));
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getArray(callableStatement.getArray(i));
    }

    private Integer[] getArray(Array array) throws SQLException {
        if (array == null) {
            return null;
        }
        return (Integer[]) array.getArray();
    }
}
