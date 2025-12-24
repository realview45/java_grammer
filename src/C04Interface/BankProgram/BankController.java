package C04Interface.BankProgram;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
/*
        <계좌개설 및 입출금 서비스>
        1.계좌객체 : id(auto_increment Long), name(String), accountNumber(String), balance(long)
        2.자료구조 :  계좌객체를 담아둘 자료구조는 Map
        3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요.
            3-1)계좌개설 : "이름"과 사용하실 "계좌번호"와 현재 "가지고있는돈"을 입력하세요. -> 자동으로 id값 증가되어 객체 생성
            3-2)계좌조회 : 계좌조회서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요. -> 계좌주명, 계좌번호번호, 잔고를 보기좋게 출력
            3-3)입금 : 계좌입금서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요. -> 입금전 잔액, 입금후 잔액 출력
            3-4)출금 : 계좌출금서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요. -> 잔액검증 -> "출금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력
            3-5)송금 : 송금서비스입니다. 본인의 계좌번호, 상대방의 계좌번호, 송금금액을 입력해 주세요. -> 잔액검증 -> "송금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력.
        4.주의사항
            4-1)프로그램은 상시적 실행될수 있도록 전체코드를 while(true)처리
            4-2)main메서드에서 입출력 처리를 하고, 입금(deposit), 출금(withdraw), 송금(transfer)기능에 대한 핵심 메서드는 BankAccount클래스에 생성.
         */
public class BankController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accountList = new ArrayList<>();
//        서비스객체를 생성해서 핵심로직을 호출하는 방식
        BankService bs = new BankService();
        while (true) {
            System.out.println("원하시는 서비스 번호를 입력해주세요.\n" +
                    "1)계좌개설\t\t" +
                    "2)계좌조회\t\t" +
                    "3)입금\n" +
                    "4)출금\t\t\t" +
                    "5)송금");
            String serviceNumber = sc.nextLine();
            if (serviceNumber.equals("1")) {
                System.out.println("계좌개설 : \"이름\"과 사용하실 \"계좌번호\"와 현재 \"가지고있는돈\"을 입력하세요.");
                System.out.print("이름 : ");
                String name = sc.nextLine();
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                System.out.print("가지고있는돈 : ");
                long balance = Long.parseLong(sc.nextLine());
                BankAccount ba = new BankAccount(name, accountNumber, balance);
                accountList.add(ba);
                bs.inquiry(ba);
            } else if (serviceNumber.equals("2")) {
                System.out.println("계좌조회 : 계좌조회서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요.");
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                BankAccount ba=find(accountList,accountNumber);
                if(ba==null){
                    System.out.println("유효하지 않은 계좌입니다.");
                    continue;
                }
                bs.inquiry(ba);
            } else if (serviceNumber.equals("3")) {
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                BankAccount ba=find(accountList,accountNumber);
                if(ba==null){
                    System.out.println("유효하지 않은 계좌입니다.");
                    continue;
                }
                System.out.println("입금 금액 :");
                long money = Long.parseLong(sc.nextLine());
                bs.deposit(money, ba);
                bs.inquiry(ba);
            } else if (serviceNumber.equals("4")) {
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                BankAccount ba=find(accountList,accountNumber);
                if(ba==null){
                    System.out.println("유효하지 않은 계좌입니다.");
                    continue;
                }
                System.out.println("출금 금액 :");
                long money = Long.parseLong(sc.nextLine());
                bs.withdraw(money, ba);
                bs.inquiry(ba);
            }else if (serviceNumber.equals("5")) {
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                BankAccount ba = find(accountList, accountNumber);
                if (ba == null) {
                    System.out.println("유효하지 않은 계좌입니다.");
                    continue;
                }
                System.out.print("상대방 계좌번호 : ");
                String accountNumber2 = sc.nextLine();
                BankAccount ba2 = find(accountList, accountNumber2);
                if (ba2 == null) {
                    System.out.println("유효하지 않은 계좌입니다.");
                    continue;
                }
                System.out.println("송금 금액 :");
                long money = Long.parseLong(sc.nextLine());
                bs.transfer(money, ba, ba2);
                bs.inquiry(ba);
            }
        }
    }
    public static BankAccount find(List<BankAccount> accountList, String accountNumber){
        BankAccount ba = null;
        for (BankAccount a : accountList) {
            if (a.getAccountNumber().equals(accountNumber)) {
                ba = a;
                break;
            }
        }
        return ba;
    }
}
