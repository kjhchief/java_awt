package ezen.ams;

import java.awt.Choice;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.IOException;
import java.io.RandomAccessFile;


public class FileAccountRepository implements AccountRepository {
	
	private static final String FILE_PATH = "account.dbf";
	
	private static final int RECORD_COUNT_LENGTH = 4;
	
	private static final int NUMBER_LENGTH = 20;
	private static final int OWNER_LENGTH = 10;
	private static final int PWD_LENGTH = 8;
	private static final int REST_MONEY_LENGTH = 40;
	
	// 총 레코드 사이즈 : 78바이트
	private static final int RECORD_LENGTH = NUMBER_LENGTH + OWNER_LENGTH + PWD_LENGTH + REST_MONEY_LENGTH;    
	
	private RandomAccessFile file;
	
	private int recordCount = 0;
	
	public FileAccountRepository() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		if (file.length() != 0) {
			recordCount = file.readInt(); //readInt(): 스트림에서 Int값을 읽는다.
		}
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void save(Account account) throws IOException {
		// 파일의 마지막 위치로 파일 포인터 이동.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		String accountNumber = account.getAccountNumber(); // file.writeUTF(name); 이거 왜 못쓰나? 친구 이름은 10바이트로 저장하기로 했기에,걍 wireUTF고 하면 몇바이트인지 알 수가 없음. 62바이트 구조가 무너진다.
		String accountOwner = account.getAccountOwner();
		int password = account.getPassword();
		long restMoney = account.getRestMoney();
		
		int charCount = accountNumber.length();
		for (int i = 0; i < (NUMBER_LENGTH); i++) { // 계좌번호는 숫자니까 하나당 1바이트라 2로 안 나눔. 
			file.writeChar((i < charCount ? accountNumber.charAt(i) : ' ')); 
		}
		
		
		
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account[] getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAccount(String number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAccountGUI(TextField nameTF, TextField accountNumTF, TextField pwdTF, TextField inputMoneyTF,
			Choice choice, TextField rentMoneyTF, TextArea contentsArea) {
		// TODO Auto-generated method stub
		
	}



}
