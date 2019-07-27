package com.dustdawn.web.action;



import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dustdawn.entity.Customer;
import com.dustdawn.entity.LinkMan;
import com.dustdawn.service.LinkManService;
import com.dustdawn.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	LinkMan linkman = new LinkMan();
	LinkManService linkManService;
	
	//接收属性的参数要有get/set方法
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNotBlank(linkman.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name", "%"+linkman.getLkm_name()+"%"));
		}
		System.out.println(linkman.getCustomer());
		if(linkman.getCustomer()!=null&&linkman.getCustomer().getCust_id()!=null) {//查询customer.cust_id为页面提交的linkman的客户id的linkman对象
			dc.add(Restrictions.eq("customer.cust_id",linkman.getCustomer().getCust_id()));
		}
		PageBean pageBeanList = linkManService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pageBeanList);
		//转发
		return "list";
	}
	
	public String add() throws Exception {
		linkManService.save(linkman);
		
		return "toList";
	}
	public String toEdit() throws Exception {
		LinkMan linkmanReturn = linkManService.getById(linkman.getLkm_id());
		ActionContext.getContext().put("linkman", linkmanReturn);
		return "edit";
	}
	


	public LinkMan getModel() {
		return linkman;
	}


	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
	
	
	
	
	
}
