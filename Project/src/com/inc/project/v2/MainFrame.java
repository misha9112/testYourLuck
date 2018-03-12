package com.inc.project.v2;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	CardLayout cl;

	JPanel mainPanel;
	JPanel stagePanel;
	JPanel lastPanel;

	JButton startBtn;
	JButton exitBtn;
	JButton yesBtn;
	JButton noBtn;
	JButton resetBtn;

	JLabel titleLabel;
	JLabel stage1Label;
	JLabel lastStageLabel;

	TestYourLuck test;
	String str;

	public MainFrame() {
		setTitle("Main Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 300, 300);
		setResizable(false);

		cl = new CardLayout();
		setLayout(cl);

		init();

		setVisible(true);
	}

	public void init() {
		initComponent();
		initEvent();
	}

	private void initEvent() {
		MouseListener ml = new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				String text = ((JButton) e.getComponent()).getText();
				if (text.equals("START")) {
					cl.next(getContentPane());
				} else if (text.equals("EXIT")) {
					System.exit(0);
				} else if (text.equals("Yes")) {
					str = test.choice(1);
					if (str.equals("die")) {
						cl.show(getContentPane(), "mainPanel");
					}else {
//						cl.next(getContentPane());
					}
				} else if (text.equals("No")) {
					str = test.choice(2);
					if (str.equals("die")) {
						cl.show(getContentPane(), "mainPanel");
					}else {
//						cl.next(getContentPane());
					}
				} else if (text.equals("돌아가기")) {
					cl.show(getContentPane(), "mainPanel");
				}
			}
		};

		startBtn.addMouseListener(ml);
		exitBtn.addMouseListener(ml);
		yesBtn.addMouseListener(ml);
		noBtn.addMouseListener(ml);
		resetBtn.addMouseListener(ml);
		//
	}

	public void initComponent() {
		// 메인
		mainPanel = new JPanel();
		startBtn = new JButton("START");
		startBtn.setPreferredSize(new Dimension(100, 50));
		exitBtn = new JButton("EXIT");
		exitBtn.setPreferredSize(new Dimension(100, 50));
		titleLabel = new JLabel("운빨좆망겜에 오신걸 환영합니다.");

		mainPanel.add(titleLabel);
		mainPanel.add(startBtn);
		mainPanel.add(exitBtn);
		add(mainPanel, "mainPanel");

		// 스테이지
		stagePanel = new JPanel();
		yesBtn = new JButton("Yes");
		yesBtn.setPreferredSize(new Dimension(100, 50));
		noBtn = new JButton("No");
		noBtn.setPreferredSize(new Dimension(100, 50));
		stage1Label = new JLabel("스테이지1의 문구를 집어 넣을 것.");
		stagePanel.add(stage1Label);
		stagePanel.add(yesBtn);
		stagePanel.add(noBtn);
		add(stagePanel);

		// 결과
		lastPanel = new JPanel();
		resetBtn = new JButton("돌아가기");
		resetBtn.setPreferredSize(new Dimension(100, 50));
		lastStageLabel = new JLabel("스테이지10 통과 후 문구를 집어 넣을것.");
		lastPanel.add(lastStageLabel);
		lastPanel.add(resetBtn);
		add(lastPanel);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
