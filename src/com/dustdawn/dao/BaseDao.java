package com.dustdawn.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	void saveOrUpdate(T t);
	void save(T t);
	void delete(T t);
	//8大基本数据类型的包装类和String类型都实现了Serializable
	void delete(Serializable id);
	void update(T t);
	T getById(Serializable id);
	//总记录数
	Integer getTotalCount(DetachedCriteria dc);
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
