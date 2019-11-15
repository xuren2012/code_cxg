package com.cxg.login.dao;

import com.cxg.login.pojo.User;

/**
 * 这是用户操作类接口
 * @author YTF
 *
 */
 
 
public interface UserDao {

	/**
	 * 用户登录接口
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 返回登录是否成功
	 */
	public abstract boolean isLogin(String username, String password);

	/**
	 * 用户注册接口
	 * 
	 * @param user
	 *            要注册的用户信息
	 */
	public abstract void regist(User user);

}
