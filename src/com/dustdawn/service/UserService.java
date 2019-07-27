package com.dustdawn.service;

import com.dustdawn.entity.User;

public interface UserService {
	//执行登录业务
	User getUserByCodePassword(User user);

	void regist(User user);
	

}
