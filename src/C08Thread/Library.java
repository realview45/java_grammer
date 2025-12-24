package C08Thread;

public class Library {
    private static int  bookCount = 100;
//    syncronized : 메소드내에서 1개의 스레드만을 실행되도록 보장.
//    public synchronized static void borrow(){
    public static void borrow(){
        if(bookCount>0){
            try {
                Thread.sleep(100);//객체만들어져서 줄선다 1.단일스레드 1000번쉰다 2.멀티스레드 100ms후 우르르
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount-=1;
            System.out.println("대출 완료");
        }else{
            System.out.println("대출 불가");
        }
    }
    public static int getBookCount(){
        return bookCount;
    }
}
