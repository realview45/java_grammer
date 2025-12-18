package C02MethodClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C01Method {//문제풀이보다 클래스를 만들어보기
    public static void main(String[] args) {
////        for문을 활용해 1~10까지 total값 구하여 출력
//        int sum =0;
//        for(int i=1;i<=10;i++){
//            sum+=i;
//        }
//        System.out.println(sum);


//        위 코드의 중복이 지속적으로 발생된다면, 반복을 피하기 위해 코드의 기능을 모듈(메서드)화하여 별도로 분리
//        메서드 기본호출방식 : 클래스명.메서드명() 또는 객체명.메서드명()
        System.out.println(C01Method.getTotal(30,40));
//        같은 클래스내에서 정의된 클래스메서드의 호출은 클래스명 생략가능
        System.out.println(getTotal(10,20));

        List<String> myList = new ArrayList<>();
//        Collections.sort();
    }
//    접근제어자(public), 클래스메서드여부(static)/객체메서드(static x), 반환타입(int, String, 배열, void 등), 매개변수(input값)
    //클래시 실행의 기준점 : main 메서드 메인에서 getTotal호출하여 원하는 total값을 구하도록 함
    //매개변수 값에 따라 달라지는 동적인 메서드
    public static int getTotal(int start, int end){
        int total = 0;
        for (int i=start;i<=end;i++){
            total +=i;
        }
        return total;
    }
}
