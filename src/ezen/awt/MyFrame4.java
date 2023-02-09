package ezen.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridLayout
 * 
 * @Author 김재훈
 * @Date 2023. 1. 17.
 */
public class MyFrame4 extends Frame {
//	Button b1, b2, b3, b4;
	Button[] buttons;

	public MyFrame4() {
		this("기본타이틀");
	}

	public MyFrame4(String title) {
//		b1 = new Button("1");
//		b2 = new Button("2");
//		b3 = new Button("3");
//		b4 = new Button("4");
		buttons = new Button[100];
		for (int i = 0; i < buttons.length; i++) {
//			buttons[i]= new Button(String.valueOf(i+1));
			buttons[i]= new Button((i+1)+""); 
		}
	}

	// 현재 프레임의 배치 설정 메소드
	public void initLayout() {
		setLayout(new GridLayout(10, 10));
//		add(b1);
//		add(b2);
//		add(b3);
//		add(b4);
		for (Button button : buttons) { //불러오는 거니까 이거 쓴다.
			add(button);
		}

	}

	// 이벤트 소스에 이벤트 리스너 연결
	public void addEventListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		MyFrame4 frame4 = new MyFrame4("AWT 컴포넌트들");

		frame4.initLayout();
		frame4.addEventListener();
		frame4.setSize(800, 600);
		frame4.setVisible(true);
	}

}
