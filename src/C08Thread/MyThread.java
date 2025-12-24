package C08Thread;
                //MyThread -> Thread(run -깡통) -> Runnable(run)
public class MyThread extends Thread{
//    스레드를 실행(.start)하면 Thread클래스 내에 run메소드가 호출
//    그런데, Thread클래스의 run메소드는 비어있으므로, 상속받아 오버라이딩
    @Override
    public void run(){
        System.out.println("스레드 실행");
    }
}
