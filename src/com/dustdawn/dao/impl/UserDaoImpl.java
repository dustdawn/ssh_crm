package com.dustdawn.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dustdawn.dao.UserDao;
import com.dustdawn.entity.User;


//HibernateDaoSupport为dao注入sessionFactory
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	//继承模板
	

	public User getByUserCode(final String user_code) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
					String hql = "from User where user_code = ? ";
					Query query = session.createQuery(hql);
					query.setParameter(0, user_code);
					User user = (User) query.uniqueResult();
				return user;
			}
		});
		
		
	}

}
