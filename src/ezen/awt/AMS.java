package ezen.awt;

public class AMS {

	public static void main(String[] args) {
		// Frame을 확장한 사용자 정의 Frame 생성
//		MyFrame frame = new MyFrame("EZEN-BANK AMS");
		MyFrame2 frame = new MyFrame2("EZEN-BANK AMS");
		// Frame의 배치 설정
		frame.init();
		// Frame의 이벤트 처리 등록
		 frame.addEventListener();
		// Frame의 사이즈 설정
		frame.setSize(500, 600);
		// Frame을 화면에 보이기
		frame.setVisible(true);
	}

}
