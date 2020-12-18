package top.bluesword.org.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;

/**
 * 通过继承DefaultCommentGenerator类 设置实体类对应数据库字段的中文注释
 * @author 李林峰
 */
public class RemarksCommentGenerator extends DefaultCommentGenerator {

    /**
     * 设置实体类 属性注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            field.addJavaDocLine(" */");
        }
        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        if (primaryKeyColumns.size()==1 && introspectedColumn == primaryKeyColumns.get(0)) {
            field.addAnnotation("@TableId");
        }
    }

    /**
     * 设置实体类 getter注释
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            method.addJavaDocLine("/**");
            method.addJavaDocLine(" * 获取:" + introspectedColumn.getRemarks());
            method.addJavaDocLine(" */");
        }
    }

    /**
     * 设置实体类 setter注释
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            method.addJavaDocLine("/**");
            method.addJavaDocLine(" * 设置:" + introspectedColumn.getRemarks());
            method.addJavaDocLine(" */");
        }
    }
}