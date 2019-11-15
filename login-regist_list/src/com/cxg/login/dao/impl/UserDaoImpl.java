package com.cxg.login.dao.impl;

import java.util.ArrayList;

import com.cxg.login.dao.UserDao;
import com.cxg.login.pojo.User;

/**
 * 这是用户的具体操作类
 * 
 * @author Administrator
 * @version V1.0
 */
public class UserDaoImpl implements UserDao {
	// 为了让多个方法使用同一个集合，把集合定义为成员变量
	// 仅限于类内使用，加限定private
	// 为让多个对象共享一个成员变量，加static
	private static ArrayList<User> array = new ArrayList<>();

	@Override
	public boolean isLogin(String username, String password) {
		// 遍历集合，获取每一个用户信息，并与传递过来的信息进行匹配
		boolean flag = false;
		for (User u : array) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public void regist(User user) {
		// 把用户信息保存到集合
		// ArrayList<User> array = new ArrayList<>();
		array.add(user);
	}

}
