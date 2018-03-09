package com.inc.project.v2;

import java.util.Scanner;

public class TestYourLuck {
	public static void main(String[] arg0) {
		Scanner scanner = new Scanner(System.in);
		int a;
		int ran = (int) (Math.random() * 2 + 1);
		int i = 10;
		int dcnt = 0;
		System.out.println("Game Start!");
		while (i > 1) {
			System.out.println("1. Yes\n2. No\n3. Exit");
			a = scanner.nextInt();
			System.out.println(ran);

			if (ran == a) {
				System.out.println("You Die");
				i = 10;
				ran = (int) (Math.random() * 2 + 1);
				dcnt++;
			} else if (a == 3 || dcnt == 100) {
				System.out.println("Death Count : " + dcnt);
				return;
			}
			ran = (int) (Math.random() * 2 + 1);
			i--;
		}

	}
}