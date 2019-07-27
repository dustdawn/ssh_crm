package com.dustdawn.dao;

import com.dustdawn.entity.User;

public interface UserDao extends BaseDao<User>{

	User getByUserCode(String user_code);

}
