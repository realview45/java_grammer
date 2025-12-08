package C01Basic;

//클래스의 명명규칙(외우기)
//1)반드시 public class명과 파일명이 일치해야함
//2)일반적으로 대문자알파벳으로 시작

//한 파일내에 class 여러개 가능, public class는 하나, 대표 클래스다구리

public class C00HelloWorld3 {
    //1)main메서드는 java파일 실행시 실행의 시작점이자, 가장 먼저 실행되는 메서드
    //2)public static void: 어디에서든 접근가능하고(public static), 반환(리턴)값이 없는(void) 메서드
    //3)메서드명, 변수명은 일반적으로 소문자알파벳으로 시작
    public static void main(String[] args) {
        //print 단축어 : sout
        System.out.println("hello world");//반드시 세미콜론으로 명령문 종료
        //메서드를 호출할때는 메서드명()를 통해 호출
        System.out.println(method2());
//        //는 컴파일 대상에서 제외처리하는 주석. 단축키 : ctrl + /
        /* 단축키 : ctrl + shift + /
        여러줄의 주석처리를 이와 같은 방법으로
        깔끔하게 주석처리하는 것도 가능.
        */
    }
    //직접 생성한 리턴값이 있는 메서드 예시
    public static int method2(){
        return 10;
    }

}
