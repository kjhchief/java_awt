package ezen.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * AWT 비주얼 컴포넌트와 컨테이너 알아보기.
 * 
 * @Author 김재훈
 * @Date 2023. 1. 17.
 */
public class MyFrame3 extends Frame {
	Checkbox cb1, cb2;
	Checkbox manRadio, womanRadio;
	CheckboxGroup cBox;
	Choice choice;
	Choice accountChoice;
	Button windowButton, dialogButton, fdDialogButton;

	public MyFrame3() {
		this("기본타이틀");
	}

	public MyFrame3(String title) {
		cb1 = new Checkbox("운동");
		cb2 = new Checkbox("공부", true);
		cBox = new CheckboxGroup();
		manRadio = new Checkbox("남자", false, cBox);
		womanRadio = new Checkbox("여자", true, cBox);
		choice = new Choice();
		choice.add("Java");
		choice.add("C");
		choice.add("HTML");
		choice.add("CSS");
		choice.add("JavaScript");

		accountChoice = new Choice();
		AccountType[] list = AccountType.values();
		for (AccountType accountType : list) {
			accountChoice.add(accountType.getName()); // toString왜 쓰는가? add의 인자는 String이어야해서?
		}
		windowButton = new Button("윈도우");
		dialogButton = new Button("다이얼로그");
		fdDialogButton = new Button("파일다이얼로그");

	}

	// 현재 프레임의 배치 설정 메소드
	public void initLayout() {
		setLayout(new FlowLayout());
		add(cb1);
		add(cb2);
		add(manRadio);
		add(womanRadio);
		add(choice);
		add(accountChoice);
		add(windowButton);
		add(dialogButton);
		add(fdDialogButton);

	}

	// 이벤트 소스에 이벤트 리스너 연결
	public void addEventListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		windowButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openWindow();
			}
		});
		dialogButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openDialog();
			}
		});
		fdDialogButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openFileDialog();
			}
		});

	}

	public void openWindow() {
		Window window = new Window(this);
		window.setSize(500, 600);
		window.setLocation(100, 100);
		window.setVisible(true);
	}

	public void openDialog() {
		Dialog dialog = new Dialog(this);
		dialog.setTitle("점심 맛있게 드세요");
		dialog.setSize(400, 300);
		dialog.setVisible(true);
	}
	
	public void openFileDialog() {
//		FileDialog fd = new FileDialog(this, "열기", FileDialog.LOAD);
		FileDialog fd = new FileDialog(this, "저장", FileDialog.SAVE);
		fd.setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame3 frame3 = new MyFrame3("AWT 컴포넌트들");

		frame3.initLayout();
		frame3.addEventListener();
		frame3.setSize(800, 600);
		frame3.setVisible(true);

	}

}
