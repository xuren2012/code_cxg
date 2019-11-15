package com.cxg.login.test;

import java.util.Scanner;

import com.cxg.login.dao.UserDao;
import com.cxg.login.dao.impl.UserDaoImpl;
import com.cxg.login.game.GuessNumber;
import com.cxg.login.pojo.User;

/**
 * �û�������
 * 
 * @author YTF
 *
 */
public class UserTest {

	public static void main(String[] args) {
		// ѭ��
		while(true){
			//��ӭ����
			System.out.println("==============��ӭ����=====================");
			System.out.println("1��¼");
			System.out.println("2ע��");
			System.out.println("3�˳�");
			System.out.println("����������ѡ��");
			Scanner sc = new Scanner(System.in);
			String choiceString = sc.nextLine();
			//�������Ϊȫ�ֱ���
			UserDao ud = new UserDaoImpl();
			switch(choiceString){
			case "1":
				System.out.println("==========��¼����=============");
				System.out.println("�������û�����");
				String username = sc.nextLine();
				System.out.println("���������룺");
				String password = sc.nextLine();
				
				//���õ�¼����
				boolean flag = ud.isLogin(username, password);
				if(flag){
					if(flag){
						System.out.println("��¼�ɹ������Կ�ʼ����Ϸ����");
						System.out.println("����y/n");
						while(true){
							String resultString = sc.nextLine();
							if(resultString.equals("y")){
								//����Ϸ
								GuessNumber.start();
								System.out.println("������y/n");
							}else{
								break;
							}
						}
					}
					System.out.println("ллʹ�ã���ӭ�´ι��٣�");
					System.exit(0);
				}else{
					System.out.println("�û�������������󣬵�¼ʧ�ܣ�");
				}
				break;
			case "2":
				//ע�����
				System.out.println("=======ע�����========");
				System.out.println("�������û�����");
				String newUsername = sc.nextLine();
				System.out.println("���������룺");
				String newPassword = sc.nextLine();
				//��װ����
				User user = new User();
				user.setUsername(newUsername);
				user.setPassword(newPassword);
				//����ע�Ṧ��
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
