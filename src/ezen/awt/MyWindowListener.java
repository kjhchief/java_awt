package ezen.awt;

import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.w3c.dom.events.MouseEvent;

/**
 * WindowEvent가 발생하였을 때 처리를 위한 이벤트 처리 클래스(이벤트 리스너)
 * @Author 김재훈
 * @Date 2023. 1. 16.
 */
public class MyWindowListener implements WindowListener, MouseListener {
	MyFrame myFrame;
	MyWindowListener(MyFrame myFrame){
		this.myFrame = myFrame;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("window Opened.");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	// 구현은 안 해도 지우면 안 됨. 그럼 규약 안 지킨거니까.
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("window closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("window iconfied");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("window deiconfied");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("window activated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("window deactivated");
		
	}
	
	// 마우스 이벤트 처리
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
//		System.out.println("mouse clicked");
		myFrame.tf.setText("마우스를 클릭하였습니다.");
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
