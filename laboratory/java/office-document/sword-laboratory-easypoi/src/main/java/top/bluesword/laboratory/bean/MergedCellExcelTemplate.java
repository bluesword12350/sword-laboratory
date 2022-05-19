package top.bluesword.laboratory.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author 李林峰
 */
@Data
public class MergedCellExcelTemplate implements IExcelDataModel, IExcelModel {

	private Integer rowNum;

	private String errorMsg;

	@Excel(name = "主键",fixedIndex = 0)
	private Integer id;

	@Excel(name = "名称",fixedIndex = 1)
	private String name;

	@Excel(name = "日期",importFormat = "yyyy.MM.dd",exportFormat = "yyyy.MM.dd")
	private LocalDate date;

	private String style;

	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
