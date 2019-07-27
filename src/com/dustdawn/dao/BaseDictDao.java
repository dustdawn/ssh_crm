package com.dustdawn.dao;

import java.util.List;

import com.dustdawn.entity.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
