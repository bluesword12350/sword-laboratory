package top.bluesword.web.laboratory.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

/**
 * @author 李林峰
 */
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] integers, JdbcType jdbcType) throws SQLException {
        Connection conn = preparedStatement.getConnection();
        Array array = conn.createArrayOf(null, integers);
        preparedStatement.setArray(i, array);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getArray(resultSet.getArray(s));
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getArray(resultSet.getArray(i));
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getArray(callableStatement.getArray(i));
    }

    private String[] getArray(Array array) throws SQLException {
        if (array == null) {
            return null;
        }
        return (String[]) array.getArray();
    }
}
