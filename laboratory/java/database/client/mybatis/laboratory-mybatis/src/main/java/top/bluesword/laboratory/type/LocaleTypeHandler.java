package top.bluesword.laboratory.type;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

/**
 * @author 李林峰
 */
public class LocaleTypeHandler extends BaseTypeHandler<Locale> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Locale locale, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,locale.toString());
    }

    @Override
    public Locale getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return LocaleUtils.toLocale(string);
    }

    @Override
    public Locale getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return LocaleUtils.toLocale(string);
    }

    @Override
    public Locale getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return LocaleUtils.toLocale(string);
    }
}
