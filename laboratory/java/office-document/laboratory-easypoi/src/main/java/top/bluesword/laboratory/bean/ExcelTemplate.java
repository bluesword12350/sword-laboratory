package top.bluesword.laboratory.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 李林峰
 */
@Data
@NoArgsConstructor
public class ExcelTemplate implements IExcelDataModel, IExcelModel {

	private Integer rowNum;

	private String errorMsg;
	
	@Excel(name = "主键",fixedIndex = 0)
	private Integer id;
	
	@Excel(name = "名称",fixedIndex = 1)
	private String name;

	@Excel(name = "主键",fixedIndex = 2)
	private String id2;

	@Excel(name = "日期",importFormat = "yyyy/MM/dd",exportFormat = "yyyy/MM/dd")
	private Date date;

	@Excel(name = "时间戳",importFormat = "yyyy/MM/dd",exportFormat = "yyyy/MM/dd")
	private Long timestamp;

	private String style;

	private Boolean isNew;

	ExcelTemplate(Integer id, String name, String style ,Boolean isNew) {
		this.id = id;
		this.name = name;
		this.style = style;
		this.date = new Date();
		this.timestamp = System.currentTimeMillis();
		this.isNew = isNew;
	}

	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
