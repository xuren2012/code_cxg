package com.cxg.login.dao.impl;

import java.util.ArrayList;

import com.cxg.login.dao.UserDao;
import com.cxg.login.pojo.User;

/**
 * �����û��ľ��������
 * 
 * @author Administrator
 * @version V1.0
 */
public class UserDaoImpl implements UserDao {
	// Ϊ���ö������ʹ��ͬһ�����ϣ��Ѽ��϶���Ϊ��Ա����
	// ����������ʹ�ã����޶�private
	// Ϊ�ö��������һ����Ա��������static
	private static ArrayList<User> array = new ArrayList<>();

	@Override
	public boolean isLogin(String username, String password) {
		// �������ϣ���ȡÿһ���û���Ϣ�����봫�ݹ�������Ϣ����ƥ��
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
		// ���û���Ϣ���浽����
		// ArrayList<User> array = new ArrayList<>();
		array.add(user);
	}

}
