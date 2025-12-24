package C07ExceptionFileParsing;
import java.util.Scanner;
public class C01ExceptionBasic {
    public static void main(String[] args) {
//        예외처리 기본 : 예외가 발생할 것으로 예상되는 코드를 try로 감싼다. ((가장중요))
//        예외처리 목적 : 1)사용자에게 적절한 에러메시지 전달(큰목적) 2)예외발생시 디버깅을 위한 로그기록
        System.out.println("나눗셈 프로그램입니다.");
        Scanner sc = new Scanner(System.in);
        System.out.println("분자를 입력해주세요");
        try{
            int head = Integer.parseInt(sc.nextLine());
            System.out.println("분모를 입력해주세요");
            int tail = Integer.parseInt(sc.nextLine());
            int result = head/tail;
            System.out.println("두 수를 나눈 값은" + result);
//            catch를 통해 예상되는 예외클래스를 분기처리한다.
        }catch(ArithmeticException error){
//            사용자에게 메시지 전달(가정)
            System.out.println("0으로 나누시면 안됩니다."); //둘다 로그에 남김
//            시스템에 디버깅을 위한 로그 자세히 기록((에러발생시 로그 뒤져 디버깅 근거자료))
            error.printStackTrace();                    //둘다 로그에 남김
        }catch(NumberFormatException e){
            System.out.println("문자를 입력하시면 안됩니다.");
            e.printStackTrace();
//            Exception은 모든 예외클래스의 조상클래스. 구체적인 예외클래스가 catch부에 있다면, 해당 부분으로 우선
        }catch (Exception e){
            System.out.println("예상치 못한 에러가 발생했습니다.");
            e.printStackTrace();
        }finally{
            System.out.println("예외가 발생하든 발생하지 않든 무조건 실행되는 구문");
        }
//        예외처리를 하지 않을경우 프로그램은 강제종료. 예외처리를 할경우 프로그램은 예외가 발생하더라도 지속

        System.out.println("예외발생하더라도 예외처리를 한 후에 실행되는 코드");
    }
}
