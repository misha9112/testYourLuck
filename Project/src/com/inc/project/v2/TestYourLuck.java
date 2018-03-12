package com.inc.project.v2;

public class TestYourLuck {
	static int random = (int) (Math.random() * 2 + 1);
	static String str;
	public static String choice(int i) {
		if (i == random) {
			System.out.println("You Die!");
			str = "die";
			random = (int) (Math.random() * 2 + 1);
			return str;
		} else {
			System.out.println("You Alive!");
			str = "alive";
			random = (int) (Math.random() * 2 + 1);
			return str;
		}
	}
}