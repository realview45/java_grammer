package C04Interface.BankProgram;
//사용자와의 인터페이스를 담당하는 프로그램 계층
//엔티티계층으로서 객체에 대한 상태값을 관리
public class BankAccount {
    private String name;
    private String accountNumber;
    private long balance;

    public BankAccount(String name, String accountNumber, long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    //    최종 금액을 update : 아래 메서드를 통해서 입/출금 모두에 사용.
    // balance가 private이므로 update작업만 엔티티계층에서 수행
    public void updateBalance(long balance){
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
