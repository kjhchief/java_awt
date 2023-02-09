package ezen.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.border.Border;

/**
 * 현재 클래스가 화면구성하고, 이벤트 리스너는 내부 클래스 이용하여 구현
 * 
 * @Author 김재훈
 * @Date 2023. 1. 16.
 */
public class MyFrame2 extends Frame {

	Label label; // 왜 private은 안 붙이나? 어차피 화면 용도라서 어차피 노출 되니까?
	Choice choice;
	Button button, addButton;
	Panel panel;
	TextField tf;

	public MyFrame2() {
		this("기본타이틀");
	}

	public MyFrame2(String title) {
		super(title);
		this.label = new Label("계좌종류");
		this.choice = new Choice();
		choice.add("전체");
		choice.add("입출금계좌");
		choice.add("마이너스계좌");
		this.button = new Button("조회");
		panel = new Panel();
		tf = new TextField(10);
		addButton = new Button("등록");

	}

	// 현재 프레임의 배치 설정 메소드
	public void init() {
		// 현재 컨테이너(Frame)의 배치관리자 설정
//		setLayout(new FlowLayout());
		// Wiindow를 확장한 모든 컨테이너의 디폴트 레이아웃 매니저는 BorderLayout
		setLayout(new BorderLayout());

		// panel의 디폴트 레이아웃 매니저는 FlowLayout
//		panel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 명시적으로.
//		FlowLayout fl = (FlowLayout)panel.getLayout(); //다운 캐스팅............
//		fl.setAlignment(FlowLayout.LEFT);

		panel.setLayout(new BorderLayout(10, 5));
		panel.add(label, BorderLayout.WEST);
		panel.add(tf, BorderLayout.CENTER);
		panel.add(addButton, BorderLayout.EAST);
		// 현재 프레임에 컴포넌트 배치
		add(panel, BorderLayout.NORTH);
		add(choice, BorderLayout.WEST);
		add(button, BorderLayout.CENTER);
	}

	// 이벤트 소스에 이벤트 리스너 연결
	public void addEventListener() {
//		this.addWindowListener(new MyWindowListener(this)); 
//		addButton.addMouseListener(new MyWindowListener(this));
		// 클래스가 메소드 안에 있다. 지역 내부 클래스.
		/* 	
		class MyEventListener extends WindowAdapter implements MouseListener{

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				tf.setText("마우스 클릭");
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		}
		*/
		
		// 익명 지역 내부 클래스
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("SSup");
				System.exit(0);
			}
		});
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf.setText("마우스 클릭!!");
			}
		
		});

	}
	
	// 멤버 내부클래스를 이용한 이벤트 리스너 구현
	// 어댑터클래스 활용
	/*
	class MyEventListener extends WindowAdapter implements MouseListener{

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			tf.setText("마우스 클릭");
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	*/
}
