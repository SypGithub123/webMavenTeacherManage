package com.po;

import java.util.List;

public class PageBean {
	private int page = 1;//页数
	private int rows = 5;//显示记录数
	private int maxPage;//总页数
	private List<?> pageList;//返回结果集
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int page, int rows, int maxPage, List<?> pageList) {
		super();
		this.page = page;
		this.rows = rows;
		this.maxPage = maxPage;
		this.pageList = pageList;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public List<?> getPageList() {
		return pageList;
	}
	public void setPageList(List<?> pageList) {
		this.pageList = pageList;
	}
	
}