package C04Interface.BankProgram;
//핵심로직(잔고검증, 금액합산 등)을 수행하는 프로그램 계층
public class BankService {
//    계좌조회
    public void inquiry(BankAccount ba){
        String name = ba.getName();
        String accountNumber = ba.getAccountNumber();
        //        현재 얼마있는 조회
        long current = ba.getBalance();
        System.out.println("이름은 " + name + " 계좌번호는 " + accountNumber + " 금액은 " + current);
    };

    public void deposit(long money, BankAccount ba){
//        현재 얼마있는 조회
        long current = ba.getBalance();
//        그 금액과 money를 합산하여 새로운 balance update
        long newBalance = current + money;
        ba.updateBalance(newBalance);
    };

    public boolean withdraw(long money, BankAccount ba){
//        현재 얼마있는 조회 && 가능한 잔고인지 체크
        long current = ba.getBalance();
        if(current < money){
            return false;
        }else {
//        그 금액에서 money를 차감하여 새로운 balance update
            long newBalance = current - money;
            ba.updateBalance(newBalance);
            return true;
        }
    }
//    송금
    public boolean transfer(long money, BankAccount ba, BankAccount ba2){
//        현재 얼마있는 조회 && 가능한 잔고인지 체크
        long current = ba.getBalance();
        long current2 = ba2.getBalance();
        if(current < money){
            return false;
        }else {
//        그 금액에서 money를 차감하여 새로운 balance update
            long newBalance = current - money;
            ba.updateBalance(newBalance);
            long newBalance2 = current2 + money;
            ba2.updateBalance(newBalance2);
            return true;
        }
    }
}
