package top.bluesword.laboratory.entity;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "L_TEST")
public class LTest {
    @Id
    @Column(name = "TEST_ID")
    @KeySql(sql = "SELECT LOWER(SYS_GUID()) FROM DUAL",order = ORDER.BEFORE)
    private String testId;

    @Column(name = "TEST_VALUE")
    private String testValue;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}