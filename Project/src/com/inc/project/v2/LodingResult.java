package com.inc.project.v2;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LodingResult extends JFrame {
	
	
	CardLayout cl;
	JPanel loadingPanel, livePanel, diePanel;
	JButton liveBtn, dieBtn;
	
	public LodingResult() {
		setTitle("Wating.....");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setResizable(false);
		
		init();
		
		cl = new CardLayout();
		setLayout(cl);
		
		setVisible(true);
	}
	
	public void init() {
		initComponent();
		initPanel();
		initLoading();
		initEvent();
	}
	
	private void initEvent() {
		
	}

	private void initComponent() {
		liveBtn = new JButton("다음 스테이지 도전");
		dieBtn = new JButton("메인화면으로");
		liveBtn.setBounds(getContentPane().getWidth() / 2, getContentPane().getHeight() - 150, 200, 100);
		dieBtn.setBounds(getContentPane().getWidth() / 2, getContentPane().getHeight() - 150, 200, 100);

	}
	
	private void initLoading() {
		new Thread(()->{
			try {
				Thread.sleep(3000);
				cl.next(getContentPane());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	
	private void initPanel() {
		loadingPanel = new JPanel();
		loadingPanel.setBackground(Color.red);
		
		
		livePanel = new JPanel();
		livePanel.setBackground(Color.BLUE);
		livePanel.add(liveBtn);
		
		
		diePanel = new JPanel();
		livePanel.setBackground(Color.GREEN);
		diePanel.add(dieBtn);
		
		add(loadingPanel);
		add(livePanel);
		add(diePanel);
		
		
	}

	public static void main(String[] args) {
		new LodingResult();
	}
}
