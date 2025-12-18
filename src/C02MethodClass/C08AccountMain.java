package C02MethodClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C08AccountMain {
    public static void main(String[] args) {
        var list2 = new ArrayList<ArrayList<Integer>>();
        //        계좌개설(객체생성)
////        List를 계좌객체를 담는 자료구조로 사용
//        List<Account> list =new ArrayList<Account>();
//        list.add(new Account("김진경","12345",3000));
//        list.add(new Account("경진김", "54321",0));
//
////  계좌로 찾음(unique)
////        계좌1(계좌번호)"12345"에서 계좌2"54321"로 송금(5000)
////        내 객체를 찾아서 50000원을 차감하고, 상대방 객체를 찾아서 50000원을 가산한다.
//
//        Account sender = null;
//        Account receiver = null;
//        boolean isSend = false;
//        int money = 50000;
//        for (Account a : list){
//            if(a.getAccountNumber().equals("12345")){
//                sender = a;
//                if(a.getBalance()>money){
//                    isSend = true;
//                }
//            }
//            if(a.getAccountNumber().equals("54321")){
//                receiver = a;
//            }
//        }
//        if(sender!=null&&receiver!=null){
//            if(isSend){//이체성공
//                System.out.println(money + "원이 이체되었습니다.");
//                sender.setBalance(sender.getBalance()-money);
//                receiver.setBalance(receiver.getBalance()+money);
//
//                System.out.println("송금계좌: " + sender.toString());
//                System.out.println("이체계좌: " + receiver.toString());
//                System.out.println(list);
//            }
//            else{//이체실패
//                System.out.println(money + "원이 이체실패하였습니다. 잔액이 부족합니다.");
//                System.out.println("송금계좌: " + sender.toString());
//                System.out.println(list);
//            }
//        }
//        else{
//            System.out.println(money + "원이 이체실패하였습니다. 사용자를 찾을 수 없습니다.");
//        }

//        Map을 계좌객체를 담는 자료구조로 사용
        var accountMap = new HashMap<String,Account>();
        accountMap.put("12345", new Account("hong1","12345",100000000));
        accountMap.put("54321",new Account("hong2","54321",0));

        Account a = accountMap.get("12345");
        Account b = accountMap.get("54321");
        a.transfer(b,50000);
        System.out.println(accountMap);

        System.out.println(a);
        System.out.println(b);
    }
}
//Account클래스 - 계좌주명(name), 계좌번호(accountNumber-String), 잔고(balance-long)
//변수선언, 생성자, toString오버라이드, 잔고변경메서드필요
class Account{
//    참조자료형은 초기값 null
    private static long staticId;
    private Long id;
    private String name;
    private String accountNumber;
//    원시자료형은 각 자료형에 맞는 초기값
    private long balance;
    public String getName() {
        return name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    //        setBalance보다는 의도를 명확히한 메서드명을 사용하기를 권장
    public void setBalance(long balance) {
        this.balance = balance;
    }
//    public void transfer(송금받을 객체, 송금할 돈){
//        송금할 객체의 잔고가 있는지 체크
//        송금할 객체의 돈을 차감하고,
//        송금받을 객체의 돈을 가산
//    }

    public void transfer(Account targetAccount, long money){
        if(this.balance < money){
            return;
        }
//        송금할 객체에서 돈을 차감
        this.balance -= money;
//        송금받을 객체의 돈을 가산
        targetAccount.balance += money;
    }
    public Account(String name, String accountNumber, long balance) {
        staticId++;
        this.id = staticId;//id값 autoIncrement
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}