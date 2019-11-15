package com.cxg.login.test;

import java.util.Scanner;

import com.cxg.login.dao.UserDao;
import com.cxg.login.dao.impl.UserDaoImpl;
import com.cxg.login.game.GuessNumber;
import com.cxg.login.pojo.User;

/**
 * �û������ࣨ���ϰ棩
 * 
 * @author Administrator
 *
 */
public class UserTest {

	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		// ѭ��
		while (true) {
			// ��ӭ����
			System.out.println("----------��ӭ����---------------");
			System.out.println("1��¼");
			System.out.println("2ע��");
			System.out.println("3�˳�");
			System.out.println("����������ѡ��");
			// ����¼��ѡ�񣬸���ѡ��ʵ�ֲ�ͬ�Ĳ���
			Scanner sc = new Scanner(System.in);

			String choiceString = sc.nextLine();
			switch (choiceString) {
			case "1":
				System.out.println("----------��¼����---------------");
				System.out.println("�������û�����");
				String username = sc.nextLine();
				System.out.println("���������룺");
				String password = sc.nextLine();
				// ���õ�¼����
				boolean flag = ud.isLogin(username, password);
				if (flag) {
					// System.out.println("��¼�ɹ���");
					// ========================================
					if (flag) {
						System.out.println("��¼�ɹ���������Ϸ����");
						System.out.println("������y/n");
						while (true) {
							String resultString = sc.nextLine();
							if (resultString.equals("y")) {
								// ����Ϸ
								GuessNumber.start();
								System.out.println("����������y/n");
							} else {
								break;
							}

						}
					}
					// ========================================
					System.out.println("ллʹ�û�ӭ�´�������");
					// break;
					System.exit(0);
				} else {
					System.out.println("�û�������������󣬵�¼ʧ�ܣ�");
				}
				break;

			case "2":
				System.out.println("----------ע�����---------------");
				System.out.println("�������û�����");
				String newUsername = sc.nextLine();
				System.out.println("���������룺");
				String newPassword = sc.nextLine();

				// ��װ���ݵ�����
				User user = new User();
				user.setUsername(newUsername);
				user.setPassword(newPassword);

				// ����ע�Ṧ��
				ud.regist(user);
				System.out.println("ע��ɹ���");
				break;
			case "3":
			default:
				System.out.println("ллʹ�ã���ӭ�´�������");
				System.exit(0);
				break;
			}

		}

	}

}
