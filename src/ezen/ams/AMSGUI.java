package ezen.ams;

/**
 * @Author 김재훈
 * @Date 2023. 1. 21.
 * 
 *       *발생 문제점 1) while 무한반복하니까 cpu 점유율 20% ㅋㅋㅋ
 */
public class AMSGUI {

	public static void main(String[] args) {

		AccountRepository repository = new ArrayAccountRepository(100);
		AccountFrame frame = new AccountFrame("HOONI-BANK AMS", repository);
		// 가상데이터 등록
		repository.addAccount(new Account("1111-2222", "김재훈", 1111, 100000));
		repository.addAccount(new MinusAccount("1111-3333", "김대출", 1111, 10000, 10000000, "2022-10-3"));

		frame.initLayout();
		frame.addEventListener();
		frame.setSize(480, 460);
		frame.setVisible(true);
		frame.rentMoneyTF.setEditable(false);
		frame.nameTF.setText("홍길동");
		frame.accountNumTF.setText("1111-4444");
		frame.pwdTF.setText("0000");
		frame.InputMoneyTF.setText("10000");
//		frame.rentMoneyTF.setText("5000");

	}

}
