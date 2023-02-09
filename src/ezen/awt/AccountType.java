package ezen.awt;

/**
 * AMS에서 다루는 계좌 종류 목록
 * @Author 김재훈
 * @Date 2023. 1. 17.
 */
public enum AccountType {
	GENERAL_ACCOUNT("입출금계좌"), MINUS_ACCOUNT("마이너스 계좌"), STOCK_ACCOUNT("주식 계좌");

	private final String name;
	private AccountType(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
