package com.dustdawn.web.action;




import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dustdawn.entity.Customer;
import com.dustdawn.service.CustomerService;
import com.dustdawn.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	
	private Customer customer = new Customer();
	private CustomerService customerService;
	
	private File photo;//上传的文件会自动封装到File对象中
	//在后台提供一个与前台input type=file组件name属性名相同的属性
	//固定后缀Filename
	private String photoFileName;
	//固定后缀ContentType  
	private String photoContentType;
	//接收属性的参数要有get/set方法
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		PageBean pageBeanList = customerService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pageBeanList);
		//转发
		return "list";
	}
	//选择客户
	public String select() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		PageBean pageBeanList = customerService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pageBeanList);
		//转发
		return "select";
	}
	
	
	//同时保存修改
	public String add() throws Exception {
		if(photo!=null) {
		System.out.println(photoFileName);
		System.out.println(photoContentType);
		photo.renameTo(new File("G:/update/"+photoFileName));
		}
		
		customerService.save(customer);
		
		return "toList";
	}
	
	


	public String toEdit() throws Exception {
		Customer customerReturn = customerService.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", customerReturn);
		return "edit";
	}
	//获得行业统计
	public String industryCount() throws Exception {
		List<Object[]> list = customerService.getIndustryCount();
		ActionContext.getContext().put("list",list);
		//转发
		return "industryCount";
	}



	public Customer getModel() {
		return customer;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public Integer getPageSize() {
		return pageSize;
	}




	public File getPhoto() {
		return photo;
	}




	public void setPhoto(File photo) {
		this.photo = photo;
	}




	public String getPhotoFileName() {
		return photoFileName;
	}




	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}




	public String getPhotoContentType() {
		return photoContentType;
	}




	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	
}
