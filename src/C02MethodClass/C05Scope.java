package C02MethodClass;
//변수의 유효범위 : 클래스변수와 객체변수는 클래스 전역에서 사용 가능
public class C05Scope {
//    클래스변수(static변수)
    static int v1 = 10;
//    객체변수 : 객체메서드에서만 접근 가능 main은 static메서드기 때문에 객체를 가정하지 X 그래서 불가능
    int v2 = 20;
    public static void main(String[] args) {
        System.out.println(v1);
//        System.out.println(v2);
//        지역변수 : 지역변수는 해당 메서드내에서만 사용가능
        int v3 = 10;
        scope1(v3);
        System.out.println(v3);

        C04Person p1 = new C04Person();
        p1.setName("kim");
        p1.setEmail("kim@naver.com");
        p1.setAge(30);
        scope2(p1);
        System.out.println(p1.returnPersonInfo()); //name : lee
    }
    public static void scope1(int v3){ //call by value : 값을 통한 호출. 원시자료형의 값만을 전달.
        v3=30;
        System.out.println(v3);
    }
    public static void scope2(C04Person person){ //call by reference : 참조에 의한 호출. 힙메모리 주소값 전달.
        //객체를 주고받을 때 안의 값이 바뀔수 있으므로 주의
        person.setName("lee");
        System.out.println(person.returnPersonInfo());//name : lee
    }

}
