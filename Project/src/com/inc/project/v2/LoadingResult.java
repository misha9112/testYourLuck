package com.inc.project.v2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoadingResult extends JFrame {

	//카드레이아웃은 밖에서 계속 접근해야하므로 따로 객체생성해둠
	
	CardLayout cl;
	JButton loadingBtn, liveBtn, dieBtn;
	JPanel firstPanel, secondPanel, thirdPanel;
	String str;
	//MainFrame mf = new MainFrame();
	public static boolean live;
	

	public void init() {
		initComponent();
		initThread();
		initEvent();
	}
	
	public void run() {
		setTitle("Main Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 1000, 700);
		setResizable(false);
		
		cl = new CardLayout();
		
		setLayout(cl);

		init();

		setVisible(true);
	}
	
	private void initEvent() {
		
		MouseListener ma = new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				str = ((JButton)e.getComponent()).getText();
				if (str.equals("메인 화면으로")) {
					live = true;
				}
				if (str.equals("다음 스테이지로")) {
					live = false;
				}
			}
		};
		
		liveBtn.addMouseListener(ma);
		dieBtn.addMouseListener(ma);
		
		
	}

	public void initComponent() {
		
		loadingBtn = new JButton("로딩중입니다...");
		loadingBtn.setBounds(getWidth() / 2 - 100, getHeight() - 150, 200, 50);
		liveBtn = new JButton("다음 스테이지로");
		liveBtn.setBounds(getWidth() / 2 - 100, getHeight() - 150, 200, 50);
		dieBtn = new JButton("메인 화면으로");
		dieBtn.setBounds(getWidth() / 2 - 100, getHeight() - 150, 200, 50);
		
		firstPanel = new JPanel(null);
		firstPanel.setBackground(Color.RED);
		secondPanel = new JPanel(null);
		secondPanel.setBackground(Color.ORANGE);
		thirdPanel = new JPanel(null);
		thirdPanel.setBackground(Color.GREEN);
		
		firstPanel.add(loadingBtn);
		secondPanel.add(liveBtn);
		thirdPanel.add(dieBtn);
		
		add(firstPanel, "first");
		add(secondPanel);
		add(thirdPanel, "third");
	
	}
	
	private void initThread() {
		new Thread(()->{
			try {
				Thread.sleep(3000);
				if(TestYourLuck.choice() == "alive") {
					cl.next(getContentPane());
				}else {
					cl.show(getContentPane(), "third");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}).start();
	}

	public static void main(String[] args) {
		new LoadingResult();
	}
	
}
