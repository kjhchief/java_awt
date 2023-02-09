package ezen.ams;

/**
 * Account 클래스를 상속받는 마이너스 계좌
 * 
 * @author 김재훈
 * @date 2023. 1. 4.
 */
public class MinusAccount extends Account {
	// 새롭게 추가된 속성
	private long borrowMoney;
	private String borrowDate;

	public MinusAccount() {
		super(); // 부모에 자동 할당?? 되어야 하니까??? 부모 디폴트 생성자도 만들어야 하니까.

	}

	public MinusAccount(String number, String owner, int passwd, long money, long borrowMoney, String borrowDate) {
		super(number, owner, passwd, money); // 부모의 값 먼저 호출
		this.borrowMoney = borrowMoney;
		this.borrowDate = borrowDate;
	}

	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	// 잔액(restMoney - borrowMoney) 재정의(Overriding)
	public long getRestMoney() {
		return super.getRestMoney() - borrowMoney;
	}
	@Override
	public String toString() {
		
		return super.toString() + " " + borrowMoney + " " + borrowDate;
		
	}

}
