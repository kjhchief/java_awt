package ezen.chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

public class ChatPanel extends Panel {
	Panel connectPanel, inputPanel;
	Label nicknameLabel;
	TextField nickNameTF, inputTF;
	Button connectButton, sendButton;

	TextArea messageTA;
	JList<String> userList;

	public ChatPanel() {
		this.connectPanel = new Panel();
		inputPanel = new Panel();
		nicknameLabel = new Label("대화명: ");
		nickNameTF = new TextField("사용하고자 하는 대화명 입력");
		inputTF = new TextField();
		connectButton = new Button(" 연  결 ");
		sendButton = new Button(" 보내기 ");
		messageTA = new TextArea(10, 20);

		String[] list = { "김재훈", "이대한", "김정석", "박찬우" };
		userList = new JList<String>(list);

	}

	// 컴포넌트 배치
	public void initLayout() {
		// 레이아웃 담당 매니저 설정
		setLayout(new BorderLayout());

		connectPanel.setLayout(new BorderLayout());
		connectPanel.add(nicknameLabel, BorderLayout.WEST);
		connectPanel.add(nickNameTF, BorderLayout.CENTER);
		connectPanel.add(connectButton, BorderLayout.EAST);

		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(inputTF, BorderLayout.CENTER);
		inputPanel.add(sendButton, BorderLayout.EAST);

		add(connectPanel, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(inputPanel, BorderLayout.SOUTH);

	}

	// 컴포넌트 이벤트 처리
	public void eventRegist() {
		nickNameTF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nickNameTF.setText("");
			}
		});
		/*
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nickName = nickNameTF.getText();
				messageTA.append(nickName + "님이 입장하셨습니다.");

				System.out.println(e.getButton());
				System.out.println(MouseEvent.BUTTON1);
				if (e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("왼쪽 버튼이 눌렸습니다.");
				}
				System.out.println(e.getX());
				System.out.println(e.getXOnScreen());
				System.out.println(e.getModifiersEx());

			}
		});
		*/
		connectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});

		// 텍스트필드 액션이벤트 처리
		inputTF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();

			}
		});

		// 보내기 버튼 액션이벤트 처리
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();

			}
		});

	}
	// 서버 연결
	private void connect() {
		// 서버 연결...은 나중에
		String nickName = nickNameTF.getText();
		messageTA.append(nickName + "님이 입장하셨습니다.");
	}
	
	
	// 메세지 전송 처리
	private void sendMessage() {
		String inputMessage = inputTF.getText();
		inputTF.setText("");
		// 서버로 전송하는 것은 나중에...
		messageTA.append(inputMessage + "\n");
	}

	// 메세지 수신 처리

}
