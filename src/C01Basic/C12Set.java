package C01Basic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class C12Set {
    public static void main(String[] args) {
//        set의 특성 : 중복X, 순서보장X, 성능O(1) 조합
        Set<String> mySet = new HashSet<>();
        mySet.add("야구");
        mySet.add("농구");
        mySet.add("야구");
        mySet.add("축구");
        System.out.println(mySet.contains("야구"));//O(1)의 복잡도

//        수찾기(1920) -> 다시 풀어보기

//        TreeSet : 데이터를 오름차순정렬
        Set<String> mySet2 = new TreeSet<>();
        mySet2.add("야구");
        mySet2.add("농구");
        mySet2.add("야구");
        mySet2.add("축구");
        System.out.println(mySet2);

//        백준 : 숫자카드(10815)
//        프로그래머스 : 폰켓몬
    }
}
