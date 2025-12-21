package C03Inheritance;

import java.util.ArrayList;
import java.util.List;

public class C06AbstractMain {
    public static void main(String[] args) {
//        추상클래스는 구현체가 없는 메서드가 있으므로, 기본적으로 객체 생성 불가능
//        AbstractAnimal a1 = new AbstractAnimal();

          AbstractDog d1 = new AbstractDog();
          d1.makeSound1();
          d1.makeSound2();

////        인터페이스는 모든 메서드가 abstract인 클래스 구현체 필요
////        인터페이스는 구현체가 없으므로, 별도의 객체 생성 불가
//          List<Integer> myList = new ArrayList<>();
    }
}
//클래스에 추상(abstract)메서드가 하나라도 있으면 클래스 앞에 abstract 키워드가 붙음
abstract class AbstractAnimal{
    void makeSound1(){
        System.out.println("동물은 소리를 냅니다.");
    }
//    abstract메서드는 메서드를 선언만하고 구현이 없는 메서드
//    해당 클래스를 상속받는 클래스에서 abstract메서드 구현.
    abstract void makeSound2();

}
class AbstractDog extends AbstractAnimal{

//    구현되지 않은 makeSound2를 구현.
    @Override
    void makeSound2() {
        System.out.println("멍멍멍");
    }
}
//final키워드를 통해 상속 불가한 클래스로 변경.
final class FinalParents{

}
