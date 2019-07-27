package com.dustdawn.service.impl;

import org.hibernate.Session;

import com.dustdawn.dao.UserDao;
import com.dustdawn.dao.impl.UserDaoImpl;
import com.dustdawn.entity.User;
import com.dustdawn.service.UserService;
import com.dustdawn.utils.MD5Utils;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	
	public User getUserByCodePassword(User user) {
		//1 根据登陆名称查询登陆用户
		User existU = userDao.getByUserCode(user.getUser_code());
		//2 判断用户是否存在.不存在=>抛出异常,提示用户名不存在
		if(existU==null){
			throw new RuntimeException("用户名不存在!");
		}
		//3 判断用户密码是否正确=>不正确=>抛出异常,提示密码错误
		if(!existU.getUser_password().equals(MD5Utils.md5(user.getUser_password()))){
			throw new RuntimeException("密码错误!");
		}
		//4 返回查询到的用户对象
	
		return existU;
	}
	
	public void regist(User user) {
		User existU = userDao.getByUserCode(user.getUser_code());
		if(existU!=null) {
			throw new RuntimeException("用户名已存在");
		}
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		userDao.save(user);
		
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	

}
