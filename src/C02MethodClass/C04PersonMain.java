package C02MethodClass;

public class C04PersonMain {
    public static void main(String[] args) {
////        회원가입 예시
//        String name1 = "hong1";
//        String email1 = "hong1@naver.com";
//        int age1 = 30;
//        printMember(name1, email1, age1);
//        String name2 = "hong2";
//        String email2 = "hong2@naver.com";
//        int age2 = 40;
//        printMember(name2, email2, age2);
//      요소(속성)들이 그룹화되어 있지않다보니, 중복과 코드의 가독성이 저하
//      클래스에 속성을 정의하여, 사람 객체로 생성
//        C04Person p1 = new C04Person();
//        p1.name = "hong1";
//        p1.email = "hong1@naver.com";
//        p1.age = 30;//p1의 객체 힙메모리공간에 값 저장 그룹화되어 가독성, 사용성이 높아진다.
//        //접근제어자 외부에서 위와같이 수정은 위험 -> 접근제어자 사용
//        //public : 해당객체 사용 프로젝트 어디에나접근
//        //default : 같은 패키지내에서
//        //private : 같은 클래스내에서
//
//        C04Person p2 = new C04Person();
//        p2.name = "hong2";
//        p2.email = "hong2@naver.com";
//        p2.age = 40;//p2의 객체 힙메모리공간에 값 저장
//
//
//        printMember2(p1);
//        printMember2(p2);
//      위 코드의 문제점
//        1.person객체의 변수에 외부 클래스에서 접근가능 private으로 해결
//        person객체를 personmain1 personmain2에서 사용가능
//        2.person에대한 출력코드가 외부클래스마다 중복되어 들어갈 여지
        C04Person p3 = new C04Person();
        p3.setName("hong3");
        p3.setEmail("hong3@");
        p3.setAge(30);
        printMember2(p3);
        System.out.println(p3.returnPersonInfo());
        System.out.println(p3);//객체의 힙메모리 주소반환
    }
    //       사용자정보 출력메서드(printMember)
//       예시)이름은 : xx, 이메일은 yy, 나이는 zz 입니다.
    public static void printMember(String name, String email, int age){
        System.out.println("이름: " +name +" 이메일: " + email +" 나이: " + age);
    }
    public static void printMember2(C04Person person){//객체의 주소값이 매개변수로 전달
//        System.out.println("이름: " +person.name() +" 이메일: " + person.email() +" 나이: " + person.age());
        System.out.println("이름: " +person.getName() +" 이메일: " + person.getEmail() +" 나이: " + person.getAge());
    }
}
