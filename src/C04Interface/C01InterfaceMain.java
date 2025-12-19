package C04Interface;
import java.util.*;
public class C01InterfaceMain {
    public static void main(String[] args) {
        C01Cat c1 =new C01Cat();
        c1.makeSound();
        C01Dog d1 = new C01Dog();
        d1.makeSound();

//       인터페이스 특징1 다형성 : 하나의 부모타입으로 여러 자식객체를 다룰 수 있음.
        C01AnimalInterface1 c2 =new C01Cat();
        c2.makeSound();
        C01AnimalInterface1 d2 = new C01Dog();
        d2.makeSound();

//        다형성의 장점 : 기존의 구현체(ex)ArrayList를 다른 구현체(ex-LinkedList)로 변경시 용이함이 있다.
//        구현체를 바꿔도 에러가 없다.
        List<Integer> myList = new LinkedList<>();
        myList.add(10);
        myList.add(20);
        myList.get(0);

//        인터페이스 특징2 - 다중구현(상속) 가능
        C01AnimalInterface1 c3 = new C01Cat();//울기만 하는 고양이
        c3.makeSound();
        C01AnimalInterface2 c4 = new C01Cat();//먹기만 하는 고양이
        c4.eat("츄르");

//        다중구현의 예시 - List와 Queue
        List<Integer>myList1 = new LinkedList<>();
//        myList1.get(0); 사용가능
        Queue<Integer> myList2 = new LinkedList<>();
//        myList2.get(0); 사용불가
    }
}
