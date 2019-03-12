package top.bluesword.web.laboratory.model;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class PageResult<T> {
	long total;
	List<T> rows;
	public PageResult(){}
	public PageResult(long total,List<T> Tlist){
		this.total = total;
		this.rows = Tlist;
	}
	public PageResult(PageInfo<T> pageinfo){
		this.total = pageinfo.getTotal();
		this.rows = pageinfo.getList();
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
