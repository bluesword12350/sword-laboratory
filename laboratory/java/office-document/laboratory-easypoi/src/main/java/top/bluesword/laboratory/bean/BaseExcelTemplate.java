package top.bluesword.laboratory.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import lombok.Data;

/**
 * @author 李林峰
 */
@Data
public class BaseExcelTemplate implements IExcelDataModel {

    private Integer rowNum;

    @Excel(name = "主键",fixedIndex = 0)
    private Integer id;

    @Excel(name = "名称",fixedIndex = 1)
    private String name;

}
