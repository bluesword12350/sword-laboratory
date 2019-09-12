package top.bluesword.web.laboratory.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

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

	public ExcelTemplate() {
	}

	public ExcelTemplate(Integer id, String name) {
		this.id = id;
		this.name = name;
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
}
