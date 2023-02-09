package ezen.ams;

import java.awt.Choice;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Calendar;

/**
 * AccountRepository 인터페이스 구현 클래스
 * 
 * @author 김재훈
 * @Date 2023. 1. 9.
 */
public class ArrayAccountRepository implements AccountRepository {

	private Account[] accounts;
	private int count;

	public ArrayAccountRepository() {
		this(10);
	}

	public ArrayAccountRepository(int capacity) {
		this.accounts = new Account[capacity];
	}

	// 전체계좌 목록
	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void addAccount(Account account) {
		accounts[count++] = account;

	}

	@Override
	public Account[] getAccounts() {
		return accounts;
	}

	@Override
	public Account findByNumber(String number) {
		for (int i = 0; i < count; i++) {
			String an = accounts[i].getAccountNumber();
			// 동일 계좌번호 여부 확인
			if (an.equals(number)) {
				return accounts[i]; // 메소드 빠져나가면서 찾은 객체 반환.
			}

		}
		return null; // 먼저 컴파일 에러 안 되게 리턴값 쓰고 초기화 시키기.
	}

	// 이름으로 조회 재사용 메소드
	public Account findByName(String name) {
		for (int i = 0; i < count; i++) {
			String an = accounts[i].getAccountOwner();
			if (an.equals(name)) {
				return accounts[i]; // 메소드 빠져나가면서
			}
		}

		return null;

	}

	// 계좌번호로 계좌 삭제 메소드
	@Override
	public boolean removeAccount(String number) {
		for (int i = 0; i < count; i++) {
			String an = accounts[i].getAccountNumber();// String 타입 an 변수 선언. i 번째 accounts(계좌)인데 getAccountNumber 메소드를
														// 불러서 쓴다.
			if (an.equals(number)) {
				for (int j = i; j < count - 1; j++) { // i 부터 시작한다. 걍 j로 하면 뭔가 밀림. 이유는 모름.
					accounts[j] = accounts[j + 1];
				}
				count--;
				return true;
			}
		}
		return false;
	}

	// 계좌 중복등록 방지 메소드
	public String accountDuplicate(String accountNum) {
		return null;
	}
	
	
	// 신규 계좌 등록 메소드
	public void createAccountGUI(TextField nameTF, TextField accountNumTF, TextField pwdTF, TextField InputMoneyTF, Choice choice, TextField rentMoneyTF, TextArea contentsArea) {
		Account account = null;

		String name = nameTF.getText();
		String accountNum = accountNumTF.getText();
		int pwd = Integer.parseInt(pwdTF.getText());
		long money = Long.parseLong(InputMoneyTF.getText());
//		String title = String.format("%9s %", accountNum);

		if (Valiator.isEmpty(name)) {

		}
		if (Valiator.isEmpty(accountNum)) {

		}

		// 계좌번호 중복등록 방지 코드
		Account[] list = getAccounts();
		for (int i = 0; i < getCount(); i++) {
			account = list[i];
			if (account.getAccountNumber().equals(accountNum)) {
				contentsArea.append("이미 존재하는 계좌번호입니다.(중복 등록 불가)\n");
				contentsArea.append("----------------------------------------------------------------------------\n");
				return;
			}
		}
		
		if ((choice.getSelectedItem()).equals("입출금계좌")) {
			account = new Account(accountNum, name, pwd, money);
			// 등록된 계좌 쓰기.
			contentsArea.setText("");
			contentsArea.append("입출금계좌   " + account.getAccountNumber() + "    " + account.getAccountOwner() + "     " + account.getRestMoney() + "\n");
		} else if ((choice.getSelectedItem()).equals("마이너스계좌")) {
			long rentMoney = Long.parseLong(rentMoneyTF.getText());
			Calendar now = Calendar.getInstance();
			String rentDate = String.format("%1$tF", now);
			account = new MinusAccount(accountNum, name, pwd, money, rentMoney, rentDate);
			contentsArea.setText("");
			contentsArea.append("마이너스계좌   " + account.getAccountNumber() + "    " + account.getAccountOwner() + "     " + account.getRestMoney() + "     " + ((MinusAccount) account).getBorrowMoney() + "     " + ((MinusAccount) account).getBorrowDate() + "\n");
		}

		addAccount(account);
		nameTF.setText("");
		accountNumTF.setText("");
		pwdTF.setText("");
		InputMoneyTF.setText("");
		rentMoneyTF.setText("");
		contentsArea.append("계좌가 등록 되었습니다.\n");
		contentsArea.append("----------------------------------------------------------------------------\n");

	}
}
