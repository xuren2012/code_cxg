package com.cxg.login.game;

import java.util.Scanner;

/**
 * ���ǲ�����С��Ϸ
 * 
 * @author YTF
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
			if (guessNumber > number) {// ����
				System.out.println("���µ�����" + guessNumber + "������");
			} else if (guessNumber < number) {// С��
				System.out.println("���µ�����" + guessNumber + "С����");
			} else {// ������
				System.out.println("��ϲ����" + count + "�β��У�");
				break;
			}
		}

	}

}
