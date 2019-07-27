package com.dustdawn.service;

import org.hibernate.criterion.DetachedCriteria;

import com.dustdawn.entity.LinkMan;
import com.dustdawn.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkman);
	//联系人列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//修改
	LinkMan getById(Long lkm_id);

}
