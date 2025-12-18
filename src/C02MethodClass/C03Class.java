package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C03Class {
    public static void main(String[] args) {
        //클래스명
        //1)여러메서드 포괄
        //2)객체를 위한 설계도
        //객체가 왜 필요한가?
//        클래스메서드의 기본 호출 방식
//        int result = Calculator.sum(10,20);
//        System.out.println(result);

//        클래스메서드의 문제점(클래스가 아니라 왜 객체를 써야하는가?)

//        객체가 아닌 클래스사용의 문제점 : 고유의 변수, 고유의 메서드 사용 불가
//        A부서의 매출
////        20원 매출 발생
//        Calculator.sumAcc(20);
//        System.out.println(Calculator.total);
////        30원 매출 발생
//        Calculator.sumAcc(30);
//        System.out.println(Calculator.total);
////        40원 매출 발생
//
////        B부서의 매출이려고 할 때 안됨
////        10원 매출 누적10원
//        System.out.println(Calculator.sumAcc(10));//100 -> 10이 되어야함
//
////        20원 매출 :누적30원
//        System.out.println(Calculator.sumAcc(20));//120 -> 30이 되어야함
//
//        Calculator.sumAcc(40);
//        System.out.println(Calculator.sumAcc(40));
//        누적매출 : 90원

//        객체를 활용한 부서별 매출계산
//        객체 생성 방법 : 클래스명 객체명 = new 클래스명();
        CalculatorForInstance calA = new CalculatorForInstance();
        calA.sumAcc(20);
        calA.sumAcc(30);
        calA.sumAcc(40);
        System.out.println(calA.total);

        CalculatorForInstance calB = new CalculatorForInstance();
        calB.sumAcc(10);
        calB.sumAcc(20);
        System.out.println(calB.total);

//        클래스메서드 사용 예시
        System.out.println(Math.min(10,20));

//        객체 사용 예시
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
    }
}
class Calculator {
    //static이 붙어있으면 클래스변수(클래스종속), 붙어있지않으면 객체변수
    //c1, c2 객체를 만드는 순간 힙메모리안 c1, c2 독립적인 공간발생
    //클래스 -> 객체
    static int total =0;
    //클래스메서드호출시 : 클래스명.메서드명();
    public static int sum(int a, int b){
        return a+b;
    }

    public static int sumAcc(int a){
        total += a;
        return total;
    }
}

//staic이 붙으면 클래스변수, 메서드 안붙으면 객체변수, 메서드
class CalculatorForInstance {
    int total =0;
    static int testValue =0;
    static int totalCount =4;
//    메서드에 static이 있는 경우는 클래스메서드
//    클래스메서드는 일반적으로 객체의 상태와 상관없는 독립적인 로직 수행시에 사용
    public static int sum(int a, int b){
        return a+b;
    }
//    메서드에 static이 없는 경우는 객체메서드
//객체메서드호출시 : 객체명.메서드명();
    public int sumAcc(int total){
//        this는 객체를 지칭
//        일반적으로, 매개변수와 객체변수 이름을 구분짓기 위해서 사용.
        this.total += total;
        return total;
    }
}