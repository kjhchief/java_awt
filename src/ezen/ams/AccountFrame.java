package ezen.ams;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Properties;

/**
 * GridLayout
 * 
 * @Author 김재훈
 * @Date 2023. 1. 17.
 * 
 *       발생 버그: 1) getText로 신규계좌 등록하면 계좌번호가 아닌 예금주명이 먼저 나옴=> 해결. account에 new
 *       Account로 배열 인스턴스를 생성하는데 순서가 이름을 가장 먼저 둠. 그러니 그 순서대로 나온것. 역시 컴퓨터는 거짓말을 안
 *       함 2) getText로 등록된 계좌는 계좌번호 조회로 검색이 안 됨. => 1)에서 해결 3) getText로 등록된 계좌를
 *       예금주명으로 조회하면 '해당 계좌가 없습니다' 출력. 수동으로 등록한 계좌는 검색은 되는데, 나머지 등록된 계좌 수 만큼 '해당
 *       계좌가 없습니다'가 같이 출력 => 해결. else if에서 해당 안되는 계좌는 continue로 넘어가게 만듦. 4) 공란이
 *       하나라도 있는 상태에서 상태에서 등록버튼 누르면 NumberFormatException 생김. => 해결? try catch로
 *       묶었음 => 공란 혹은 숫자인데 문자거나 이러면 이게 뜸. 로직으로 해결 필요 NumberFormatException : 숫자가
 *       들어와야 할 자리에 숫자 아닌게 들어오면 뜨는 예외. 조건문 혹은 로직을 통하여 해결하고 싶다.\ 혹은 isDigit 써보기?
 *       https://velog.io/@ddingmun8/JAVA-%EB%AC%B8%EC%9E%90%EC%97%B4%EC%9D%B4-%EC%88%AB%EC%9E%90%EC%9D%B8%EC%A7%80-%ED%8C%90%EB%B3%84%ED%95%98%EA%B8%B0
 */
public class AccountFrame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7926796168927750767L;

	enum accountChoice{
		ACCOUNT("입출금계좌"), MINUSACCOUNT("마이너스계좌");
		private String accountType;
		private accountChoice(String accountType) {
			this.accountType = accountType;
		}
		public String getAccountType() {
			return accountType;
		}
	}
	
	AccountRepository repository; // 프레임이랑 AR 연결하는 작업. (????? 이해가 안 됨.)

	GridBagLayout gridBagLayout;
	Label nameLabel, accountNumLabel, accountTypeLabel, pwdLabel, InputMoneyLabel, rentMoneyLabel, accountListLabel,
			unitLabel;
	TextField nameTF, accountNumTF, pwdTF, InputMoneyTF, rentMoneyTF;
	Button searchButton, searchButton2, deleteButton;
	TextArea contentsArea;
	Panel buttonPanel = new Panel();
	Button enterButton, searchAllButton, refreshButton;
	Choice choice;

	private static String fontName;
	private static int fontSize;

	// 초기화 블록. 여기서 프로퍼티를 읽으면 좋겠지.
	static {
		Properties prop = new Properties();
		try {
			prop.load(AccountFrame.class.getResourceAsStream("config.properties"));
			fontName = prop.getProperty("font.family");
			fontSize = Integer.parseInt(prop.getProperty("font.size"));
			System.out.println(fontName);
			System.out.println(fontSize);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public AccountFrame() {
		this("Title", null);
	}

	public AccountFrame(String title, AccountRepository repository) {
		this.repository = repository;
		accountTypeLabel = new Label("계좌종류");
		nameLabel = new Label("예금주명");
		nameTF = new TextField();
		accountNumLabel = new Label("계좌번호");
		accountNumTF = new TextField();
		searchButton = new Button("조 회");
		searchButton2 = new Button("조 회");
		deleteButton = new Button("삭 제");
		pwdLabel = new Label("비밀번호");
		pwdTF = new TextField();
		InputMoneyLabel = new Label("입금금액");
		InputMoneyTF = new TextField();
		rentMoneyLabel = new Label("대출금액");
		rentMoneyTF = new TextField();
		choice = new Choice();
		choice.add("입출금계좌");
		choice.add("마이너스계좌");
		enterButton = new Button("신규 등록");
		searchAllButton = new Button("전체 조회");
		refreshButton = new Button("    Clear    ");
		buttonPanel.add(enterButton);
		buttonPanel.add(searchAllButton);
		buttonPanel.add(refreshButton);
		accountListLabel = new Label("계좌 목록");
		unitLabel = new Label("(단위 : 원)");
		contentsArea = new TextArea();

		Font font = new Font(fontName, Font.BOLD, fontSize);
		accountTypeLabel.setFont(font);
	}

	// 현재 프레임의 배치 설정 메소드
	public void initLayout() {
		gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		add(accountTypeLabel, 0, 0, 1, 1, 0);
		add(choice, 1, 0, 2, 1, 1);
		add(nameLabel, 0, 1, 1, 1, 0);
		add(nameTF, 1, 1, 2, 1, 1);
		add(accountNumLabel, 0, 2, 1, 1, 0);
		add(accountNumTF, 1, 2, 2, 1, 1);
		add(searchButton, 3, 1, 1, 1, 0.1);
		add(searchButton2, 3, 2, 1, 1, 0.1);
		add(deleteButton, 4, 2, 1, 1, 0.1);
		add(pwdLabel, 0, 3, 1, 1, 0);
		add(pwdTF, 1, 3, 2, 1, 1);
		add(InputMoneyLabel, 0, 4, 1, 1, 0);
		add(InputMoneyTF, 1, 4, 2, 1, 1);
		add(rentMoneyLabel, 0, 5, 1, 1, 0);
		add(rentMoneyTF, 1, 5, 2, 1, 1);
		add(buttonPanel, 0, 6, 6, 1, 1);
		add(accountListLabel, 0, 7, 1, 1, 0);
		add(unitLabel, 5, 7, 1, 1, 0);
		add(contentsArea, 0, 8, 6, 2, 1);
	}

	// GridBagLayout을 이용한 컴포넌트 배치
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(3, 3, 3, 3);
		constraints.weightx = weightx; // 가중치 0.1
		constraints.weighty = 0.0;

		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		gridBagLayout.setConstraints(component, constraints);
		add(component);
	}
	// 이벤트 리스너에 들어가는 메소드들
	private void exit() {
		System.exit(0);
	}
	
	private void accountChoice() {
		if ((choice.getSelectedItem()).equals(accountChoice.ACCOUNT.getAccountType())) {
			rentMoneyTF.setEditable(false);
			rentMoneyTF.setEnabled(false);
		} else {
			rentMoneyTF.setEditable(true);
			rentMoneyTF.setEnabled(true);
		}
	}
	
	private TextField mouseClickTF(TextField text) {
		
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text.setText("");
			}

		});
		return text;
	}
	
	// 이벤트 소스에 이벤트 리스너 연결
	public void addEventListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				accountChoice();
			}
		});

		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					findByNameGUI();
				} catch (Exception e2) {
					contentsArea.append("공백 혹은 맞지않는 문자형식, 없는 계좌(catch)\n");
				}
				
			}
		});

		searchButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				findByNumberGUI();
			}
		});

		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAccountGUI();

			}
		});
		enterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					repository.createAccountGUI(nameTF, accountNumTF, pwdTF, InputMoneyTF, choice, rentMoneyTF, contentsArea);
				} catch (Exception e2) {
					contentsArea.append("공백 혹은 맞지않는 문자형식(catch)\n");
				}
			}
		});
		searchAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				accountListGUI();

			}
		});

		refreshButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contentsArea.setText("");

			}
		});

		mouseClickTF(nameTF);
		mouseClickTF(accountNumTF);
		mouseClickTF(pwdTF);
		mouseClickTF(InputMoneyTF);
		mouseClickTF(rentMoneyTF);

	}

	// 이름으로 조회
	private void findByNameGUI() {
		String name = nameTF.getText();
		// 유효성 데이터 검증.
		if (Valiator.isEmpty(name)) {
			nameTF.setForeground(Color.red);
			nameTF.setText("예금주명을 입력하세요");
		}else {
			Account account = repository.findByName(name);
			contentsArea.append(account.toString() + "\n");
		}

	}

	// 계좌 번호로 조회
	private void findByNumberGUI() {
		String accountNum = accountNumTF.getText();
		// 데이터 유효성 검증. 이거는 처음부터 하지는 말자. 배보다 배꼽이 커진다.
		if (accountNum == null || accountNum.trim().length() == 0) {
			accountNumTF.setForeground(Color.red);
			accountNumTF.setText("계좌번호를 입력하세요");
			return;
		} else {
			Account account = repository.findByNumber(accountNum);
			if (account != null) {
				contentsArea.append(account.toString() + "\n");
			} else {
				contentsArea.append("숫자와 '-'기호를 입력, 혹은 없는 계좌\n");
			}
		}
	}

	// 계좌 삭제
	private void removeAccountGUI() {
		String accountNum = accountNumTF.getText();
		boolean account = repository.removeAccount(accountNum);
		if (account != false) {
			contentsArea.append("계좌가 삭제되었습니다..\n");
		}

	}
	
	// 계좌 등록 중복 방지
	

	// 전체 계좌 목록 보기
	private void accountListGUI() {
		contentsArea.setText("   계좌종류   |\n");
		
		Account[] list = repository.getAccounts();

		for (int i = 0; i < repository.getCount(); i++) {
			Account account = list[i];
			if (account instanceof MinusAccount) {
				contentsArea.append("마이너스계좌   " + account.getAccountNumber() + "    " + account.getAccountOwner()
						+ "     " + account.getRestMoney() + "     " + ((MinusAccount) account).getBorrowMoney()
						+ "     " + ((MinusAccount) account).getBorrowDate() + "\n");
			} else {
				contentsArea.append("입출금계좌      " + account.getAccountNumber() + "    " + account.getAccountOwner() + "     " + account.getRestMoney() + "\n");

			}
		}
		contentsArea.append("----------------------------------------------------------------------------\n");

	}

	// 숫자인지 여부 확인
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
