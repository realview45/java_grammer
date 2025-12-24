package C07ExceptionFileParsing.MemberException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
/*
        <회원가입및 로그인 서비스>
        1.객체(Member) : staticId, id(auto_increment), name(String), email(String), password(String)
        2.자료구조 :  멤버객체를 담아둘 자료구조는 List
        3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요.
            3-1)회원가입 : 이름이 3, 이메일이 10, 비밀번호가 10 미만일때 에러발생 자동으로 id값 증가되어 객체 생성
            3-2)회원상세조회 : ID값이 숫자가 아니거나 회원이 없으면 에러 출력, 회원의 이름 이메일 비밀번호 출력
            3-3)회원목록조회 : 회원리스트 출력 없으면 없다고 출력
            3-4)로그인 : 이메일과 비밀번호를 입력해 이메일이 일치하지않거나 비밀번호가 일치하지않으면 에러출력 아니면 로그인 성공 출력
        4.주의사항
            4-1)프로그램은 상시적 실행될수 있도록 전체코드를 while(true)처리
            4-2)MemberController에서 입출력 처리를 하고, 기능에 대한 핵심 메서드는 MemberService클래스에 생성
                MemberRepository에 멤버목록 저장, CRUD 수행,
         */
//사용자와 인터페이싱(입출력)하는 계층
public class MemberController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService memberService = new MemberService();
        while(true){
            System.out.println("1번 : 회원가입, 2번 : 회원상세조회, 3번 : 회원목록조회, 4번 : 로그인");
            String input = sc.nextLine();
            if(input.equals("1")){
                System.out.println("회원가입서비스입니다.");
                System.out.println("이름 입력");
                String name = sc.nextLine();
                System.out.println("이메일 입력");
                String email = sc.nextLine();
                System.out.println("비밀번호 입력");
                String password = sc.nextLine();
                if(password.length()<10){
                    System.out.println("비밀번호가 너무 짧습니다.");
//                    throw new IllegalArgumentException();//예외를 던지면안됨 Controller예외에서
                    return;
                }
//                회원가입시 발생하는 예외를 적절히 try/catch
                try {
                    Member member = memberService.register(name,email,password);
                    System.out.println(member);
                }catch (NoSuchElementException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }else if(input.equals("2")){
                System.out.println("회원상세조회 서비스입니다.");
                System.out.println("ID값 입력");
                try {
                    long id = Long.parseLong(sc.nextLine());
//                회원상세조회시 발생하는 예외를 적절히 try/catch
                    Member member = memberService.findById(id);
                    System.out.println(member);
                }catch(NumberFormatException e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }else if(input.equals("3")){
                System.out.println("회원목록조회 서비스입니다.");
                List<Member>memberList = memberService.findAll();
                if(memberList.isEmpty()){
                    System.out.println("멤버가 없습니다.");
                    continue;
                }
                System.out.println(memberList);
            }else if(input.equals("4")){
                System.out.println("로그인 서비스입니다.");
                try {
                    System.out.println("이메일 입력");
                    String email = sc.nextLine();
                    System.out.println("비밀번호 입력");
                    String password = sc.nextLine();
//                예외처리 : 예외발생시, 예외의 원인출력.
                    memberService.login(email, password);
                    System.out.println("로그인 성공입니다.");
                }catch(IllegalArgumentException e){//입력값이 틀림 400
                    System.out.println(e.getMessage());
                    e.printStackTrace();//catch를 다르게 하여 상태코드를 다르게 부여 RuntimeException 안쓰는이유
                }catch(NoSuchElementException e){
                    System.out.println(e.getMessage());//404
                    e.printStackTrace();
                }
            }
        }
    }
}
