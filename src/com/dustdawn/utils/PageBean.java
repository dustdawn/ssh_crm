package com.dustdawn.utils;

import java.util.List;

public class PageBean {
	private Integer currentPage;
	private Integer totalCount;
	private Integer pageSize;
	private Integer totalPage;
	private List list;
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		
		this.currentPage = currentPage;
		if(this.currentPage==null) {
			this.currentPage = 1;
		}
		
		this.pageSize = pageSize;
		if(this.pageSize==null) {
			this.pageSize = 3;
		}
		
		//计算总页数
		this.totalPage = (this.totalCount-1+this.pageSize)/this.pageSize;
		
		if(this.currentPage<1) {
			this.currentPage = 1;
		}
		
		if(this.currentPage>totalPage) {
			this.currentPage = totalPage;
		}
		
	}
	
	//计算起始索引的方法
	public int getStart() {
		return (this.currentPage-1)*this.pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
