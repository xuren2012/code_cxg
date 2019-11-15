package com.cxg.login.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.cxg.login.dao.UserDao;
import com.cxg.login.pojo.User;

/**
 * �����û��ľ��������
 * 
 * @author YTF
 *
 */

public class UserDaoImpl implements UserDao {
	// Ϊ��֤�ļ�һ���ؾʹ�������static
	private static File file = new File("user.txt");

	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("�����ļ����ɹ���");
			// e.printStackTrace();
		}
	}

	@Override
	public boolean isLogin(String username, String password) {
		// ��������ȡÿһ���û���Ϣ�����봫�ݹ�������Ϣ����ƥ��
		boolean flag = false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				// �û���=���� eg:admin=admin
				String[] datas = line.split("=");
				if (datas[0].equals(username) && datas[1].equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("�û���¼�Ҳ�����Ϣ���ڵ��ļ���");
			// e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("�û���¼�ͷ���Դʧ�ܣ�");
					// e.printStackTrace();
				}
			}
		}
		return flag;
	}

	@Override
	public void regist(User user) {
		// ���û���Ϣ�������ı��ļ�
		/*
		 * Ϊ��ע���������һ���Ĺ����Լ���������û���=����
		 */
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			// ����
			bw.write(user.getUsername() + "=" + user.getPassword());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("�û�ע��ʧ�ܣ�");
			// e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("�û�ע���ͷ���Դʧ�ܣ�");
					// e.printStackTrace();
				}
			}

		}
	}
}
