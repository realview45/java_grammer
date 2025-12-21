package C03Inheritance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//1.Animal이름의 클래스 생성
//-void sound()메서드 : "동물이 소리를 냅니다"출력
//2.Dog이름의 클래스 생성
//-Animal클래스를 상속
//-sound2()메서드 : "멍멍멍멍"출력
//3.Cat이름의 클래스 생성
//-Animal클래스를 상속
//-sound2()메서드 : "냥냥냥냥"출력
//4.AnimalMain
//-Dog객체 생성 후 sound2메서드 호출
//-Cat객체 생성 후 sound메서드 호출
//private class는 말이 안되는 개념
public class C03AnimalMain {
    public static void main(String[] args) {
        AnimalMain main = new AnimalMain();
//        상속관계일때는 부모클래스의 타입을 자식클래스의 객체 타입으로 지정가능(중요)
        Animal d2 = new Dog();
        d2.sound();
//        부모클래스의 타입으로 지정시, 부모클래스에서 정의된 메서드만 객체에서 사용가능
//        d2.sound2();

        Queue<Integer> queue = new LinkedList<>();

        List<Integer> list = new ArrayList<>();
    }
}
class Animal{
    public void sound(){
        System.out.println("동물은 소리를 냅니다.");
    }
}
class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
    public void sound2(){
        System.out.println("멍멍멍멍");
    }
}
class Cat extends Animal{
    public void sound2(){
        System.out.println("냥냥냥냥");
    }
}
class AnimalMain{
    public AnimalMain(){
        Dog dog = new Dog();
        dog.sound2();
        Cat cat = new Cat();
        cat.sound();
    }
}