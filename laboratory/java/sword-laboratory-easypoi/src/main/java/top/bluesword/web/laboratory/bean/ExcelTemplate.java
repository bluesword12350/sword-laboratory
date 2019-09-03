package top.bluesword.web.laboratory.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class ExcelTemplate {
	
	@Excel(name = "主键")
	private Integer id;
	
	@Excel(name = "名称")
	private String name;

	@Excel(name = "名称")
	private Date date = new Date();

	@Excel(name = "名称")
	private ExcelTemplate ex;

	public ExcelTemplate() {
	}

	public ExcelTemplate(Integer id, String name,ExcelTemplate ex) {
		this.id = id;
		this.name = name;
        this.ex = ex;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ExcelTemplate getEx() {
        return ex;
    }

    public void setEx(ExcelTemplate ex) {
        this.ex = ex;
    }
}
