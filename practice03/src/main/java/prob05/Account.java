package prob05;

public class Account {
	String accountNo;
	int balance;
	
	void save(int input) {
		balance+=input;
		System.out.println(accountNo+" 계좌에 " + input + "만원이 입금되었습니다.");
	}
	void deposit(int output) {
		balance-=output;
		System.out.println(accountNo+" 계좌에 " + output + "만원이 출금되었습니다.");
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	Account(String accountNo) {
		this.accountNo = accountNo;
		this.balance = 0;
		System.out.println(this.accountNo+" 계죄가 개설되었습니다.");
	}
	
}
