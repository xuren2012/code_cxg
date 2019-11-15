package com.cxg.login.test;

import java.util.Scanner;

import com.cxg.login.dao.UserDao;
import com.cxg.login.dao.impl.UserDaoImpl;
import com.cxg.login.game.GuessNumber;
import com.cxg.login.pojo.User;

/**
 * 用户测试类
 * 
 * @author YTF
 *
 */
public class UserTest {

	public static void main(String[] args) {
		// 循环
		while(true){
			//欢迎界面
			System.out.println("==============欢迎光临=====================");
			System.out.println("1登录");
			System.out.println("2注册");
			System.out.println("3退出");
			System.out.println("请输入您的选择：");
			Scanner sc = new Scanner(System.in);
			String choiceString = sc.nextLine();
			//定义对象为全局变量
			UserDao ud = new UserDaoImpl();
			switch(choiceString){
			case "1":
				System.out.println("==========登录界面=============");
				System.out.println("请输入用户名：");
				String username = sc.nextLine();
				System.out.println("请输入密码：");
				String password = sc.nextLine();
				
				//调用登录功能
				boolean flag = ud.isLogin(username, password);
				if(flag){
					if(flag){
						System.out.println("登录成功，可以开始玩游戏啦！");
						System.out.println("玩吗：y/n");
						while(true){
							String resultString = sc.nextLine();
							if(resultString.equals("y")){
								//玩游戏
								GuessNumber.start();
								System.out.println("还玩吗？y/n");
							}else{
								break;
							}
						}
					}
					System.out.println("谢谢使用，欢迎下次光临！");
					System.exit(0);
				}else{
					System.out.println("用户名或是密码错误，登录失败！");
				}
				break;
			case "2":
				//注册界面
				System.out.println("=======注册界面========");
				System.out.println("请输入用户名：");
				String newUsername = sc.nextLine();
				System.out.println("请输入密码：");
				String newPassword = sc.nextLine();
				//封装数据
				User user = new User();
				user.setUsername(newUsername);
				user.setPassword(newPassword);
				//调用注册功能
				ud.regist(user);
				System.out.println("注册成功！");
				break;
			case "3":
				default:
					System.out.println("谢谢使用，欢迎下次再来！");
					System.exit(0);
				break;
			}
		}

	}

}
