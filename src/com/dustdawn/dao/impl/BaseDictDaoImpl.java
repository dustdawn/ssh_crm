package com.dustdawn.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.dustdawn.dao.BaseDictDao;
import com.dustdawn.entity.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//Criteria
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		dc.add(Restrictions.eq("dict_type_code",dict_type_code));
		
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
	}



}
