package ezen.awt;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridLayout
 * 
 * @Author 김재훈
 * @Date 2023. 1. 17.
 */
public class MyFrame5 extends Frame {

	GridBagLayout gridBagLayout;
	Label receiveLabel, attachLabel;
	TextField receiveTF, attachTF;
	Button searchButton;
	TextArea contentsArea;
	Button sendButton, cancelButton;
	Panel buttonPanel = new Panel();

	public MyFrame5() {
		this("기본 타이틀");
	}

	public MyFrame5(String title) {
		receiveLabel = new Label("받는사람");
		receiveTF = new TextField();
		attachLabel = new Label("첨부파일");
		attachTF = new TextField();
		searchButton = new Button("찾 기");
		contentsArea = new TextArea();
		sendButton = new Button("전 송");
		cancelButton = new Button("취 소");
		buttonPanel.add(sendButton);
		buttonPanel.add(cancelButton);
	}

	// 현재 프레임의 배치 설정 메소드
	public void initLayout() {
		gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		add(receiveLabel, 0, 0, 1, 1, 0);
		add(receiveTF, 1, 0, 2, 1, 1);
		add(attachLabel, 0, 1, 1, 1, 0);
		add(attachTF, 1, 1, 2, 1, 1);
		add(searchButton, 3, 1, 1, 1, 0.1);
		add(contentsArea, 0, 2, 4, 2, 1);
		add(buttonPanel, 0, 4, 4, 1, 1);
	}

	// GridBagLayout을 이용한 컴포넌트 배치
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(3, 3, 3, 3);
		constraints.weightx = weightx; // 가중치 0.1
		constraints.weighty = 0.0;

		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		gridBagLayout.setConstraints(component, constraints);
		add(component);
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
		MyFrame5 frame5 = new MyFrame5("AWT 컴포넌트들");

		frame5.initLayout();
		frame5.addEventListener();
		frame5.setSize(400, 400);
		frame5.setVisible(true);
	}

}
