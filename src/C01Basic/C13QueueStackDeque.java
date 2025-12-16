package C01Basic;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C13QueueStackDeque {//(중요) 문제와 같이 풀기
    public static void main(String[] args) {
        //List 중간 삽입/삭제 O(n) Queue O(1)
        //리스트 : 뒤에 더하고 앞에 걸 빼면 성능저하
        //큐 : 선입선출의 자료구조, 뒤에 더하고, 앞의 걸 뺀다.
        //스택 : 후입선출, 뒤에 더하고, 뒤에걸뺀다.
//        ArrayList(리스트) (중요 외우기)
//        장점 : 조회성능빠름
//        단점 : 중간값 삭제 remove성능저하
//        LinkedList(큐)
//        장점 : 맨앞의 값 삭제 성능빠름
//        단점 : 조회성능 저하

////        Queue 인터페이스를 LinkedList를 구현한 아래와 같은 방식으로 가장 많이 사용
////        offer(삽입), poll(삭제), peek(조회)
//        Queue<Integer> myQue = new LinkedList<>();
//        myQue.add(10);
//        myQue.add(20);
//        myQue.add(30);
////        poll은 큐에서 가장 앞의 데이터를 삭제하면서, 동시에 return하는 메서드
//        int value = myQue.poll();
//        System.out.println(value); //10
//        System.out.println(myQue); //20,30
////        peek은 큐에서 데이터를 삭제하지 않고, 가장 앞의 데이터를 return하는 메서드
//        int value2 = myQue.peek();
//        System.out.println(value2); //20
//        System.out.println(myQue); //20,30

////        while문을 통한 queue출력 방식
//        Queue<String> printerQueue = new LinkedList<>();
//        printerQueue.add("문서1");
//        printerQueue.add("문서2");
//        printerQueue.add("문서3");
//        printerQueue.add("문서4");
////        큐는 일반적으로 while문을 통해 요소를 소모
////        int size = printerQueue.size();
////        for(int i=0;i<printerQueue.size();i++){
////            System.out.println(printerQueue.poll());
////
////        }
//        while(!printerQueue.isEmpty()){
//            System.out.println(printerQueue.poll());
//        }

////        LinkedList와 ArrayList의 성능차이 비교
////        ArrayList의 장점 : 조회성능빠름, 단점 : 중간 삽입/삭제 remove(0)성능 저하
////        LinkedList 장점 : 중간 삽입/삭제 remove(0)성능 빠름, 단점 : 조회성능저하
//        LinkedList<Integer> myLinkedList = new LinkedList<>();
//        long startTime = System.currentTimeMillis();
//        for (int i=0;i<1000000;i++){
//            myLinkedList.add(0,i);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("linkedlist에 중간값 add시에 소요시간 : " + (endTime-startTime));
//
//        ArrayList<Integer> myArrayList = new ArrayList<>();
//        long startTime2 = System.currentTimeMillis();
//        for (int i=0;i<1000000;i++){
//            myArrayList.add(0,i);
//        }
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("arraylist에 중간값 add시에 소요시간 : " + (endTime2-startTime2));

//        관련문제 : 카드2, 요세푸스 문제 0

////        길이제한큐(잘 안씀)
//        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3);
////        blockingQueue.add("문서1");
////        blockingQueue.add("문서2");
////        blockingQueue.add("문서3");
////        blockingQueue.add("문서4"); //길이 초과시 에러 발생
//        blockingQueue.offer("문서1");
//        blockingQueue.offer("문서2");
//        blockingQueue.offer("문서3");
//        blockingQueue.offer("문서4"); //제한된 길이까지만 add. 에러발생X
//        System.out.println(blockingQueue);

//        우선순위 큐 : 데이터를 poll할 때 정렬된 데이터결과값(최소값/최대값) 보장
//        지속적으로 데이터가 추가/제거되면서 전체데이터가 실시간으로 변경되는 상황에 사용.
//        Queue<Integer> pq = new PriorityQueue<>();
//        pq.add(30);
//        pq.add(20);
//        pq.add(10);
//        pq.add(40);
//        pq.add(50);
//        while(!pq.isEmpty()){
////            poll할때마다 최소값을 추출하게되고, 복잡도 log(n) peek은 최소값을 확인만하고 추출은X, 복잡도 log(n)
////            전체 데이터를 모두 poll하면 복잡도 n*log(n)
//            System.out.println(pq.poll());
//        }
//        pq에서 데이터 하나를 poll : log(n)
//        pq에서 전체데이터를 모두 poll : n*log(n)
//        1)add하고 poll(log(n))
//        2)add하고 poll(log(n))
//        list에서 전체데이터를 정렬 : n*log(n)
//        1)중간중간 값을 add하고 다시 정렬하는 복잡도
//        2)n*log(n) + n*log(n) ... : n^2*log(n)

//        List<Integer> myList = new ArrayList<>();
//        myList.add(30);
//        myList.sort(Comparator.naturalOrder());
//        myList.add(20);
//        myList.sort(Comparator.naturalOrder());
//        myList.add(10);
//        myList.sort(Comparator.naturalOrder());
//        myList.add(40);
//        myList.sort(Comparator.naturalOrder());
//        myList.add(50);
//        myList.sort(Comparator.naturalOrder());
//        for(int m : myList){
//            System.out.println(m);
//        }

        //힙 자료구조는 내부적으로 정렬된 게 아니라 꺼낼때마다 최솟값
        //최소힙
        //백준 : 최소힙
        //프로그래머스 : 더 맵게

////        최대힙 : poll할때마다 최대값을 추출
//        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //카드 정렬하기

//        stack : 후입선출의 자료구조
        Stack<Integer> myStack = new Stack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.pop()); //마지막에 입력한 값을 꺼내는 것
        System.out.println(myStack.peek()); //마지막에 입력한 값을 확인만
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());

//        프로그래머스 : 올바른 괄호
//        프로그래머스 : 같은 숫자는 싫어

//      deque : addFirst, addLast, pollFirst, pollLast, peekFirst, peekLast
        Deque<Integer> myDeque = new ArrayDeque<>();
        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addFirst(30);//30, 10, 20
        System.out.println(myDeque.pollLast());//20
        System.out.println(myDeque.pollFirst());//30
        System.out.println(myDeque.pollFirst());//10

    }
}
