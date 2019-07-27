package com.dustdawn.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dustdawn.dao.LinkManDao;
import com.dustdawn.entity.Customer;
import com.dustdawn.entity.LinkMan;
import com.dustdawn.service.LinkManService;
import com.dustdawn.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao linkManDao;
	
	public void save(LinkMan linkman) {
		linkManDao.saveOrUpdate(linkman);
	}

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用Dao查询总记录数
		Integer totalCount = linkManDao.getTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage,totalCount,pageSize);
		//调用Dao查询分页列表数据
		List<LinkMan> list = linkManDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		
		return pageBean;
	}
	
	//修改联系人
	public LinkMan getById(Long lkm_id) {
		
		return linkManDao.getById(lkm_id);
	}
	
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	
	
	
	
		

}
