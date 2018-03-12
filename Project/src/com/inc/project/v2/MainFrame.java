package com.inc.project.v2;

import java.awt.BorderLayout;
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

	JPanel stageDcPanel;
	JPanel stageTextPanel;
	JPanel stageBtnPanel;

	JButton startBtn;
	JButton exitBtn;
	JButton yesBtn;
	JButton noBtn;
	JButton resetBtn;

	JLabel titleLabel;
	JLabel stage1Label;
	JLabel lastStageLabel;
	JLabel dcLabel;
	JLabel dc2Label;

	TestYourLuck test;
	String str;
	LoadingResult result;

	int dc = 0;

	public MainFrame() {
		setTitle("운빨랜덤게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 300, 300);
		setResizable(false);

		cl = new CardLayout();
		setLayout(cl);

		init();

		setVisible(true);
	}

	private void initEvent() {
		MouseListener ml = new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				String text = ((JButton) e.getComponent()).getText();
				result = new LoadingResult();
				if (text.equals("START")) {
					cl.next(getContentPane());
				} else if (text.equals("EXIT")) {
					System.exit(0);
				} else if (text.equals("Yes")) {
					result.run();
					if (result.live == false) {
						dc++;
						dc2Label.setText(String.valueOf(dc));
						cl.show(getContentPane(), "mainPanel");

					} else {
						// cl.next(getContentPane());
					}
				} else if (text.equals("No")) {
					result.run();
					if (result.live == false) {
						dc++;
						dc2Label.setText(String.valueOf(dc));
						cl.show(getContentPane(), "mainPanel");

					} else {
						// cl.next(getContentPane());
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
	}

	public void mainComponent() {
		mainPanel = new JPanel();
		startBtn = new JButton("START");
		startBtn.setPreferredSize(new Dimension(90, 50));
		exitBtn = new JButton("EXIT");
		exitBtn.setPreferredSize(new Dimension(90, 50));
		titleLabel = new JLabel("운빨좆망겜에 오신걸 환영합니다.");

		mainPanel.add(titleLabel);
		mainPanel.add(startBtn);
		mainPanel.add(exitBtn);
		add(mainPanel, "mainPanel");
	}

	public void stageComponent() {
		stagePanel = new JPanel();
		stagePanel.setLayout(new BorderLayout(0, 55));

		stageDcPanel = new JPanel();
		stageTextPanel = new JPanel();
		stageBtnPanel = new JPanel();

		yesBtn = new JButton("Yes");
		yesBtn.setPreferredSize(new Dimension(90, 50));
		noBtn = new JButton("No");
		noBtn.setPreferredSize(new Dimension(90, 50));
		dcLabel = new JLabel("DeathCount");
		dc2Label = new JLabel(" " + dc);
		stage1Label = new JLabel("스테이지1의 문구를 집어 넣을 것.");

		stageDcPanel.add(dcLabel);
		stageDcPanel.add(dc2Label);

		stageTextPanel.add(stage1Label);

		stageBtnPanel.add(yesBtn);
		stageBtnPanel.add(noBtn);

		stagePanel.add(stageDcPanel, BorderLayout.NORTH);
		stagePanel.add(stageTextPanel, BorderLayout.CENTER);
		stagePanel.add(stageBtnPanel, BorderLayout.SOUTH);

		add(stagePanel);

	}

	public void lastComponent() {
		lastPanel = new JPanel();
		resetBtn = new JButton("돌아가기");
		resetBtn.setPreferredSize(new Dimension(100, 50));
		lastStageLabel = new JLabel("스테이지10 통과 후 문구를 집어 넣을것.");
		lastPanel.add(lastStageLabel);
		lastPanel.add(resetBtn);
		add(lastPanel);
	}

	public void init() {
		initComponent();
		initEvent();
	}

	public void initComponent() {
		mainComponent();
		stageComponent();
		lastComponent();
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
