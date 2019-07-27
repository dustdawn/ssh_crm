package com.dustdawn.service.impl;

import java.util.List;

import com.dustdawn.dao.BaseDictDao;
import com.dustdawn.entity.BaseDict;
import com.dustdawn.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDictDao;
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		
		return baseDictDao.getListByTypeCode(dict_type_code);
	}
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	
}
