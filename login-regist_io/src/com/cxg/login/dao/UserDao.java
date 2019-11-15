package com.cxg.login.dao;

import com.cxg.login.pojo.User;

/**
 * �����û�������ӿ�
 * @author YTF
 *
 */
 
 
public interface UserDao {

	/**
	 * �û���¼�ӿ�
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return ���ص�¼�Ƿ�ɹ�
	 */
	public abstract boolean isLogin(String username, String password);

	/**
	 * �û�ע��ӿ�
	 * 
	 * @param user
	 *            Ҫע����û���Ϣ
	 */
	public abstract void regist(User user);

}
