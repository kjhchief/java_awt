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
 * @Author 김재훈
 * @Date 2023. 1. 16.
 */
public class NoLayoutManagerFrame extends Frame {
	
	Label label;
	TextField tf;

	public NoLayoutManagerFrame() {
		this("기본타이틀");
	}

	public NoLayoutManagerFrame(String title) {
		super(title);
		label = new Label("이름");
		tf = new TextField();

	}

	// 현재 프레임의 배치 설정 메소드
	public void initLayout() {
		setLayout(getLayout());
	}

	// 이벤트 소스에 이벤트 리스너 연결
	public void addEventListener() {

	}
	

}
