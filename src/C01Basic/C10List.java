package C01Basic;

import java.util.*;

public class C10List {
    public static void main(String[] args) {
////        List선언방법1
//        ArrayList<String> myList1 = new ArrayList<String>();
//        ArrayList<String> myList2 = new ArrayList<>();
//
////        List선언방법2
//        List<String> myList3 = new ArrayList<>();//ArrayList는 List의 일종 List는 실질적 구현체X인터페이스
//
////        초기값 세팅방법1. 개별data add
//        myList3.add("java");
//        myList3.add("python");
//        myList3.add("C++");
//        System.out.println(myList3);
//
////        초기값 세팅방법2. 배열을 리스트로 변환(잘 안쓰임)?
//        String[] arr = {"java", "python", "C++"};
//        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));
//
//        System.out.println(myList4);

//        List의 출력
//        List등의 컬렉션프레임워크 안에는 toString메서드가 구현되어있고, 자동호출되고 있다.

////        List의 안의 자료타입으로는 기본형타입은 쓸 수 없음.
//        int[] intArr = {10,20,30};
//        List<Integer> myList5 = new ArrayList<>();
//        for(int i : intArr){
//            myList5.add(i);
//        }

////        add : 리스트에 값을 하나씩 추가하는 메서드
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(0,30); //list는 중간위치에 데이터를 삽입/삭제하는 작업은 비효율적이다(스트링빌더, 버퍼)
//
////        get(index) : 특정 index의 요소 반환
//        System.out.println(myList.get(2));
//
////        size() : 리스트의 개수(길이)를 반환
//        System.out.println(myList.size());
//
////        리스트의 값 출력 방법1. 일반for문
//        StringBuilder sb = new StringBuilder();
//        sb.append('[');
//        for(int i=0;i<myList.size();i++){
//            sb.append(myList.get(i));
//            sb.append(", ");
//        }
//        sb.append("]");
//        System.out.println(sb);
////        리스트의 값 출력 방법2. 향상된for문
//        for(int i : myList){
//            System.out.println(i);
//        }

//        remove : 값 삭제
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(30);
//        myList.remove(myList.size()-1);//뒤에거 다땡겨옴 그래서 리스트는 삭제 안함 종종끝만 삭제

////        indexOf : 특정값을 찾아 index return(가장먼저나오는값) (잘안쓰임)
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(30);
//        myList.add(30);
//        System.out.println(myList.indexOf(30));
//
////        contains : 값이 있는지 없는지 여부를 리턴 (직접 구현)
//        System.out.println(myList.contains(20));

//        프로그래머스 : n의 배수 고르기

////        정렬 : 방법2가지(Collections클래스의 sort메서드 사용, 객체의 sort메서드 사용)
//        List<Integer> myList = new ArrayList<>();
//        myList.add(5);
//        myList.add(3);
//        myList.add(2);
//        myList.add(5);
//
//        Collections.sort(myList);//오름차순
//        Collections.sort(myList, Comparator.reverseOrder());//내림차순
//        System.out.println(myList);
//
//        myList.sort(Comparator.naturalOrder());//오름차순
//        myList.sort(Comparator.reverseOrder());//내림차순
//        System.out.println(myList);

//        이중리스트 : 리스트안의 리스트
//        [[1,2,3], [4,5,6]]
//        List<List<Integer>>myList = new ArrayList<>();
//        List<Integer>m1 = new ArrayList<>();
//        myList.add(m1);//myList안에 m1의 메모리 주소만 들어감
//        myList.add(new ArrayList<>());
//        myList.add(new ArrayList<>());//[[], [], []]
//        m1.add(1);
//        m1.add(2);
//        m1.add(3);//[[1, 2, 3], [], []]
//        System.out.println(myList);
//        System.out.println(myList);
//        for(int i=0;i<5;i++){
//            myList.add(new ArrayList<>());
//        }

////        [[1,2,3],[4,5,6],[7,8,9], ..., [58,59,60]]
//        List<List<Integer>> myList = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            myList.add(new ArrayList<>());
//        }
//        int cnt = 1;
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 3; j++) {
//                myList.get(i).add(cnt);
//                cnt++;
//            }
//        }
//        System.out.println(myList);

//        List<List<Integer>> myList = new ArrayList<>();
//        int cnt = 1;
//        for (int i = 0; i < 20; i++) {
//            List<Integer> m1 = new ArrayList<>();
//            myList.add(m1);
//            for (int j = 0; j < 3; j++) {
//                m1.add(cnt);
//                cnt++;
//            }
//        }
//        System.out.println(myList);

//        리스트안의 배열
//        [{10,20},{1,2,3},{4,3,2,1}]
        List<int[]> list = new ArrayList<>();
//        list.sort(new Comparator<int[]>() { //정렬 커스텀 나중에
//            @Override
//            public int compare(int[] o1, int[] o2) {
//
//            }
//        })

        int[] arr = new int[2];
        arr[0] = 10;
        arr[1] = 20;
        list.add(arr);
        list.add(new int[3]);//실전에서 많이씀
        list.get(1)[0] = 1;
        list.get(1)[1] = 2;
        list.get(1)[2] = 3;
        list.add(new int[]{4,3,2,1});
        System.out.println(list);//배열주소값이 출력. [x1배열주소, x2배열의주소, x3배열의주소]
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }
}
