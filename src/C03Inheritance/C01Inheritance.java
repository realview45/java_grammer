package C03Inheritance;
//상속 : 부모의 변수와 메서드를 자식클래스에서 물려받는 것. (extends 키워드사용)
public class C01Inheritance extends Parents{//실전에서 많이사용
                                //다중 상속 불가 부모클래스의 어떤메서드, 어떤변수를 물려받을지 모름
                                //인터페이스는 (다중 상속)다중 구현이 가능
    int b = 20;
    public static void main(String[] args) {
        C01Inheritance c1 =new C01Inheritance();
//        부모클래스의 a변수 상속
        System.out.println(c1.a);//부모클래스에서 정의한 변수가 객체안에 들어가있다.
        System.out.println(c1.b);
//        System.out.println(c1.c);//접근가능한 것만 물려받는다.
//        부모클래스의 m1메서드 상속
        c1.m1();
        c1.m2();
    }
    public void m2(){
        System.out.println("자식 클래스입니다.");
    }
//    오버라이딩(부모 메서드의 재정의) : 부모클래스의 메서드명과 자식클래스의 메서드명이 동일한 경우
//        Ovveride된 메서드임을 명시적으로 표현하는 키워드(어노테이션). 권고
//        성능최적화를 위해서 해당 키워드 붙여주는 것이 더 좋음.스프링에서 많이 쓰임.
    @Override
    public void m1(){
        System.out.println("자식클래스에서 오버라이딩한 m1입니다.");
    }
}
class Parents{
    int a =10;
//    private접근제어자는 클래스내부에서만 접근가능하므로, 자식클래스에서도 접근불가
    private int c = 30;
    public void m1(){
        System.out.println("부모클래스입니다.");
    }
}