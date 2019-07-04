package top.bluesword.web.laboratory.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.*;

public class BigDecimalArrayTypeHandler extends BaseTypeHandler<BigDecimal[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BigDecimal[] integers, JdbcType jdbcType) throws SQLException {
        Connection conn = preparedStatement.getConnection();
        Array array = conn.createArrayOf(null, integers);
        preparedStatement.setArray(i, array);
    }

    @Override
    public BigDecimal[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getArray(resultSet.getArray(s));
    }

    @Override
    public BigDecimal[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getArray(resultSet.getArray(i));
    }

    @Override
    public BigDecimal[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getArray(callableStatement.getArray(i));
    }

    private BigDecimal[] getArray(Array array) throws SQLException {
        if (array == null) {
            return null;
        }
        return (BigDecimal[]) array.getArray();
    }
}
