package ezen.chat.client;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ezenTalk {
	
	public static void setFullScreen(Frame frame) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		frame.setSize(toolkit.getScreenSize());
	}

	public static void main(String[] args) {
		Frame frame = new Frame("::: ezenTalk :::");
		ChatPanel chatPanel = new ChatPanel();
		chatPanel.initLayout();
		chatPanel.eventRegist();
		frame.add(chatPanel, BorderLayout.CENTER);
		frame.setSize(500, 700);
//		setFullScreen(frame);
		
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

}
