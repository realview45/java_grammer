package C01Basic;

import java.util.*;

public class C11Map {
    public static void main(String[] args) {
////        map : key, value로 이루어진 자료구조
//        Map<String, Integer> sports = new HashMap<>();
////        특징 : 키는 중복이 없음. value는 중복이 가능.
//        sports.put("농구", 2);
//        sports.put("축구", 3);
//        sports.put("배구", 2);
//        sports.put("농구", 3);//덮어쓰기
//
////        특징 : map key에는 순서가 없음
//        System.out.println(sports);
////        특징 : map에서 key값을 통한 검색 복잡도는 O(1)
//        System.out.println(sports.get("배구"));
//
////        map의 전체데이터 출력
////        map의 key값 접근시에는 인덱스 사용 불가능(순서가 없음)
////        keySet() : map의 전체 key목록을 반환하는 메서드
////        Set<String> mySet = sports.keySet();
//        for(String a : sports.keySet()){
//            System.out.println("key : " + a + " value : " + sports.get(a));
//        }
////      values() : map의 전체 value목록을 반환하는 메서드 (잘 안쓰임)
//        for (int a :sports.values()){
//            System.out.println(a);
//        }
//        Map<String, Integer> sports = new HashMap<>();
//        sports.put("축구",2);
//        sports.put("농구",3);
//        sports.put("배구",2);
//        sports.put("축구",3);
//
////        remove : key를 통해 map요소 삭제
//        sports.remove("축구");
//        System.out.println(sports);
//
////        putIfAbsent : key값이 없는 경우에만 put
//        sports.put("배구",10);
//        System.out.println(sports);
//
////        containsKey : 키가있으면 true, 없으면 false
//        System.out.println(sports.containsKey("배구"));
//        System.out.println(sports.containsKey("탁구"));

//        map을 통한 개수 count
//        String[] arr = {"농구", "축구", "농구", "야구", "축구"};//농구:2, 야구:1, 축구:2
//        Map<String,Integer> myMap = new HashMap<>();
//        for(String a : arr){
//            if(myMap.containsKey(a)){
//                myMap.put(a, myMap.get(a) + 1);
//            }else {
//                myMap.put(a,1);
//            }
//            getOrDefault(키값, 초기값) : key값이 있으면 있는 값 리턴, 없을 경우 초기값리턴 (외우기)
//            myMap.put(a,myMap.getOrDefault(a,0)+1);
//        }
//        System.out.println(myMap);
//
////        map의 value값 감소 로직
//        String[] arr2 = {"농구", "농구", "농구", "야구", "축구"};
////        축구:1만 남도록
//        for(String a : arr2){
//            if(myMap.containsKey(a)){
//                if(myMap.get(a)==1){
//                    myMap.remove(a);
//                }
//                else {
//                    myMap.put(a,myMap.get(a)-1);
//                }
//            }
//        }
//        System.out.println(myMap);

//        프로그래머스 : 의상

////        가장 value가 큰 key값 찾기
//        Map<String, Integer> myMap = new HashMap<>();
//        myMap.put("축구",3);
//        myMap.put("농구",2);
//        myMap.put("야구",1);
//        int max = Integer.MIN_VALUE;
//        String maxKey = "";
//        for(String a:myMap.keySet()){
//            int value = myMap.get(a);
//            if(max <value){
//                max = value;
//                maxKey = a;
//            }
//        }
//        System.out.println(maxKey);


//        백준 : 베스트셀러

//        맥스value구한다 (for문)
//        해당 맥스value를 갖는 key를 구한다. 모두 list에 더한다. (for문)

//        list를 정렬한다. 0번째 값 출력.


//        TreeMap : key를 정렬(오름차순)하여 map을 저장((꽤나 유용)
//        Map<String, Integer> myMap = new TreeMap<>();
        Map<String, Integer> myMap = new TreeMap<>(Comparator.reverseOrder());
        myMap.put("hello5", 1);
        myMap.put("hello4", 2);
        myMap.put("hello3", 3);
        myMap.put("hello2", 4);
        myMap.put("hello1", 5);
        System.out.println(myMap);

//        백준 : 파일정리 집합과 맵(맵셋문제 많이 풀어보기)
    }
}
