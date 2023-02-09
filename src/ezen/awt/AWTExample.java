package ezen.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;

public class AWTExample {

	public static void main(String[] args) {
		
		Frame frame = new Frame("처음으로 만든 창");
		frame.setSize(500,400);
		frame.setVisible(true);
		
		Button button = new Button("AWT 버튼"); 
		
		frame.add(button);
		
		
		Label label = new Label("AWT 라벨");
		frame.add(label);
		
				
		
	}

}
