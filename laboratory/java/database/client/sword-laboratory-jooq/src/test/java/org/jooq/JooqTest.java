package org.jooq;

import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class JooqTest {

    @Test
    void test() throws SQLException {
        String url = "jdbc:sqlite:database/laboratory.db";
        Connection connection = DriverManager.getConnection(url);
        try(connection) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.SQLITE);
            Result<Record1<Integer>> record1s = dslContext.selectOne().fetch();
            System.out.println(record1s.get(0).value1());
        }
    }

}
