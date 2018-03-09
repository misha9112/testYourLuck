package com.inc.project.v2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TestYourLuck extends JFrame{
	JTextArea questionArea;
	JButton yesBtn;
	JButton noBtn;
	
	
	public TestYourLuck() {
		setTitle("Main Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setResizable(false);
		
		init();
		
		setVisible(true);
	}

	public void init() {
		initComponent();  
		initEvent();
	}

	private void initEvent() {
		
	}

	private void initComponent() {
		
	}

	public static void main(String[] args) {
		new TestYourLuck();
	}
}
