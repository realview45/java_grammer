package C06EtcClass;

import java.util.*;
import java.util.stream.Stream;

public class C04GenericMain {
    public static void main(String[] args) {
//        String[] stArr = {"java", "python", "c++"};
////        stChange(stArr,0,1);
//
//        Integer[] intArr = {10,20,30};
////        //intChange(intArr, 0, 1);
//
//        allChange(stArr, 1, 2);
//        allChange(intArr, 0 ,2);
//        System.out.println(Arrays.toString(stArr));
//        System.out.println(Arrays.toString(intArr));
        GenericPerson<String> p1 = new GenericPerson<>("hongildong");
        GenericPerson<Integer> p2 = new GenericPerson<>(20);
        System.out.println(p1.getValue());
        System.out.println(p2.getValue());
    }
//    제네릭의 사용 예시(직접쓸일은 X)
    List<String> myList = new ArrayList<>();
    Stream<String> myStream;
    Optional<Student> myStudent;

//    제네릭메서드는 반환타입 왼쪽에 <T>라고 선언.
//    이때 T는 참조형변수인 객체타입만을 허용

    static void stChange(String[] stArr, int idx1, int idx2){
        String temp =  stArr[idx1];
        stArr[idx1] = stArr[idx2];
        stArr[idx2] = temp;
    }
    static <T> void allChange(T[] intArr, int idx1, int idx2){
        T temp =  intArr[idx1];
        intArr[idx1] = intArr[idx2];
        intArr[idx2] = temp;
    }
}

class GenericPerson<T> {
    private T value;

    public GenericPerson(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    //클래스 차원에 <T>가 있으면 메서드 차원에 쓸 필요없음
    public void setValue(T value) {
        this.value = value;
    }
}