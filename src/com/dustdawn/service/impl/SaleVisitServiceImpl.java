package com.dustdawn.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dustdawn.dao.SaleVisitDao;
import com.dustdawn.entity.Customer;
import com.dustdawn.entity.SaleVisit;
import com.dustdawn.service.SaleVisitService;
import com.dustdawn.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao saleVisitDao;
	public void save(SaleVisit saleVisit) {
		saleVisitDao.saveOrUpdate(saleVisit);
	}
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用Dao查询总记录数
		Integer totalCount = saleVisitDao.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
		//调用Dao查询分页列表数据
		List<SaleVisit> list = saleVisitDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		
		return pageBean;
	}
	@Override
	public SaleVisit getById(Long visit_id) {
		return saleVisitDao.getById(visit_id);
	}

	
}
