package com.dustdawn.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.dustdawn.dao.CustomerDao;
import com.dustdawn.dao.impl.CustomerDaoImpl;
import com.dustdawn.entity.Customer;

import com.dustdawn.service.CustomerService;
import com.dustdawn.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用Dao查询总记录数
		Integer totalCount = customerDao.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
		//调用Dao查询分页列表数据
		List<Customer> list = customerDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		
		return pageBean;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void save(Customer customer) {
		//维护Customer与数据字典对象的关系，由于struts2参数封装，会将参数封装到数据字典的id属性，无需手动维护
		
		//调用Dao取出数据字典对象
		
		//调用Dao保存
		customerDao.saveOrUpdate(customer);
	}

	@Override
	public Customer getById(Long cust_id) {
		return customerDao.getById(cust_id);
	}

	@Override
	public List<Object[]> getIndustryCount() {
		return customerDao.getIndustryCount();
	}

	

}
