package com.inc.project.v2;

import javax.swing.JFrame;

public class LodingResult extends JFrame {
	public LodingResult() {
		setTitle("Wating.....");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setResizable(false);

		setVisible(true);
	}

	public static void main(String[] args) {
		new LodingResult();
	}
}
