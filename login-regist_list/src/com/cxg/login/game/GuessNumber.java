package com.cxg.login.game;

import java.util.Scanner;

/**
 * ���ǲ�����С��Ϸ
 * 
 * @author Administrator
 *
 */
public class GuessNumber {

	public GuessNumber() {
	}

	public static void start() {
		// ����һ�������
		int number = (int) (Math.random() * 100) + 1;
		// ����һ��ͳ�Ʊ���
		int count = 0;
		while (true) {
			// ����¼��һ������
			Scanner sc = new Scanner(System.in);
			System.out.println("���������ݣ�1-100����");
			int guessNumber = sc.nextInt();
			count++;
			// �ж�
			if (guessNumber > number) {
				System.out.println("���µ�����" + guessNumber + "���ˣ�");
			} else if (guessNumber < number) {
				System.out.println("���µ�����" + guessNumber + "С�ˣ�");
			} else {
				System.out.println("��ϲ����" + count + "�β�������");
				break;
			}
		}

	}

}
