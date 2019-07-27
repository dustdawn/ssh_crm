package com.dustdawn.web.action;

import com.dustdawn.entity.User;
import com.dustdawn.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	private User user = new User();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() throws Exception {
		//调用Service执行登录逻辑
		User userResult = userService.getUserByCodePassword(user);
		//将返回的User对象放入session对象
		ActionContext.getContext().getSession().put("user", userResult);
		//重定向到项目首页
		return "toIndex";
	}
	//注册
	public String regist() throws Exception {
		//调用Service保存注册
		try {
			userService.regist(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//重定向到登录页面
		return "toLogin";
	}
	


	public User getModel() {
		return user;
	}
}
