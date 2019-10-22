package top.bluesword.web.laboratory.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @author 李林峰
 */
public class ExcelTemplate {
	
	@Excel(name = "主键",fixedIndex = 0)
	private Integer id;
	
	@Excel(name = "名称",fixedIndex = 1)
	private String name;

	@Excel(name = "主键",fixedIndex = 2)
	private String id2;

	private Date date;

	private String style;

	ExcelTemplate(Integer id, String name, String style) {
		this.id = id;
		this.name = name;
		this.style = style;
		this.date = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
