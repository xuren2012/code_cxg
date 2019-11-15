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
 * 这是用户的具体操作类
 * 
 * @author YTF
 *
 */

public class UserDaoImpl implements UserDao {
	// 为保证文件一加载就创建，用static
	private static File file = new File("user.txt");

	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("创建文件不成功！");
			// e.printStackTrace();
		}
	}

	@Override
	public boolean isLogin(String username, String password) {
		// 遍历，获取每一个用户信息，并与传递过来的信息进行匹配
		boolean flag = false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				// 用户名=密码 eg:admin=admin
				String[] datas = line.split("=");
				if (datas[0].equals(username) && datas[1].equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("用户登录找不到信息所在的文件！");
			// e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("用户登录释放资源失败！");
					// e.printStackTrace();
				}
			}
		}
		return flag;
	}

	@Override
	public void regist(User user) {
		// 把用户信息保存至文本文件
		/*
		 * 为了注册的数据有一定的规则，自己定义规则：用户名=密码
		 */
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			// 规则
			bw.write(user.getUsername() + "=" + user.getPassword());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.println("用户注册失败！");
			// e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("用户注册释放资源失败！");
					// e.printStackTrace();
				}
			}

		}
	}
}
