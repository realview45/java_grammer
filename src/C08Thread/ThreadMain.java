package C08Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {//main단에서는 오류 던지지말기
////        단일스레드 실행((순차적))
//        for(int i=0;i<1000;i++){
//            Library.borrow();
//        }
//        System.out.println(Library.getBookCount());

////        스레드 생성
////        방법1. 스레드 클래스 직접상속방식
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//        MyThread t3 = new MyThread();
//        MyThread t4 = new MyThread();
//        MyThread t5 = new MyThread();
//        MyThread t6 = new MyThread();
////        각 스레드는 코드의 실행순서가 보장되지 않는 비동기적 실행(main에 할당된 thread포함)
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        System.out.println("hello world");//main 실행

////        방법2. Runnable을 구현한 객체를 Thread클래스 생성자에 주입하는 방식
////        구현객체의 run메소드를 Thread객체가 가져다 사용
//        new Thread(() -> System.out.println("스레드 실행1")).start();
//        new Thread(() -> System.out.println("스레드 실행2")).start();
//        new Thread(() -> System.out.println("스레드 실행3")).start();
//        new Thread(() -> System.out.println("스레드 실행4")).start();
//        System.out.println("hello world");

////        멀티스레드 동시성 이슈 테스트
//        for (int i=0;i<1000;i++){
//            Thread t1 = new Thread(()->Library.borrow());
//            t1.start();
////            join : 한스레드의 작업이 모두 완료될때까지, 다른 스레드를 생성하지 않는 것. -> 사실상 단일스레드처럼 동작하므로, 성능저하.
//            t1.join();
//        }
//        Thread.sleep(30000);
//        System.out.println(Library.getBookCount());//main스레드는 별개로 쉬지않음

//        syncronized를 통한 동시성 제어 예시
        StringBuffer sb1 = new StringBuffer();
        sb1.append("hello"); //synchronized 메소드 ->동시성 제어
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hello"); //일반 메소드 ->동시성 문제 발생 가능성 있음.

        Map<String,String>myMap1 = new ConcurrentHashMap<>();
        myMap1.put("java", "자바");//synchronized있음 보호됨
        Map<String,String> myMap = new HashMap<>();
        myMap.put("java","자바");//synchro 없음 동시성 제어 안됨
    }
}
