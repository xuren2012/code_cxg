package com.cxg.login.game;

import java.util.Scanner;

/**
 * 这是猜数字小游戏
 * 
 * @author YTF
 *
 */
public class GuessNumber {

	public GuessNumber() {

	}

	public static void start() {
		// 产生一个随机数
		int number = (int) (Math.random() * 100) + 1;		
		// 定义一个统计变量
		int count = 0;
		while (true) {
			// 键盘录入一个数据
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入数据（1-100）：");
			int guessNumber = sc.nextInt();
			count++;
			// 判断
			if (guessNumber > number) {// 大啦
				System.out.println("您猜的数据" + guessNumber + "大啦！");
			} else if (guessNumber < number) {// 小啦
				System.out.println("您猜的数据" + guessNumber + "小啦！");
			} else {// 猜中啦
				System.out.println("恭喜您，" + count + "次猜中！");
				break;
			}
		}

	}

}
