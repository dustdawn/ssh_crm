package com.dustdawn.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.dustdawn.dao.CustomerDao;
import com.dustdawn.entity.Customer;


public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	public List<Object[]> getIndustryCount() {
		@SuppressWarnings("all")
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
			String sql = "SELECT b.dict_item_name ,COUNT(*) total FROM base_dict b,cst_customer c \r\n" + 
					"WHERE c.cust_industry = b.dict_id\r\n" + 
					"GROUP BY c.cust_industry";
					public List doInHibernate(Session session) throws HibernateException {
						SQLQuery createQuery = session.createSQLQuery(sql);
						
						return createQuery.list();
					}
		});
		return list;
	}
	


}
