package C05AnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
//        java에서는 비교를 위한 인터페이스가 대표적으로 2개 제공
//        1. Comparator인터페이스 : 인터페이스내 compare메서드만 존재//쓸 줄 알아야함
//        2. Comparable인터페이스 : 인터페이스내 compareTo메서드만 존재//안써도 됨
        List<Integer> myList = new ArrayList<>();
        myList.add(20);
        myList.add(10);
        myList.add(30);
//        java의 대부분의 정렬함수는 매개변수로 Comparator객체 요구
//        myList.sort(Comparator.naturalOrder());
//        o1과 o2의 숫자값을 마이너스 형식으로 코딩을 하되,
//        o1이 먼저 있으면 오름차순, o2가 먼저 있으면 내림차순.
        myList.sort(Comparator.comparingInt(o -> o));
        System.out.println(myList);

        List<String> myList2 = new ArrayList<>();
        myList2.add("java");
        myList2.add("python");
        myList2.add("c++");

//        기본적인 문자열정렬일때에는 Comparator커스텀을 하지 않고,
//        복잡한 자신만의 정렬기준을 가지고 정렬해야 할 때, Comparator익명객체 생성.
        Collections.sort(myList2, (o1, o2) -> o1.compareTo(o2));

        //        문자열의 길이로 정렬하되,
//        문자열의 길이가 같은 경우 알파벳순으로 정렬
//                                      익명클래스로 객체만들어 리턴
        Collections.sort(myList2, (o1, o2) -> {
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else{
                return o1.length() - o2.length();
            }
        });
        System.out.println(myList2);

//      배열, 리스트 정렬외에 java의 그외 정렬자료구조
        Queue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()- o2.length();
            }
        });
        Set<String> treeSet = new TreeSet<>((o1, o2) -> o1.length()-o2.length());

//
//      백준 절대값 힙
        Queue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            if(Math.abs(o1)-Math.abs(o2)==0) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

//        정렬(Comparator객체);
//        백준 : 선긋기
//        리스트 안의 배열 정렬
//        [{4,5} , {1,2}, {5,0}, {3,1}]
//        리스트안의 배열에 1번째 index를 기준으로 오름차순 정렬
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{4,5});
        list.add(new int[]{1,2});
        list.add(new int[]{5,0});
        list.add(new int[]{3,1});
        Collections.sort(list, (o1,o2)-> o1[1] - o2[1]);
        for(int[] a : list){
            System.out.println(Arrays.toString(a));
        }


//        백준 : 단어정렬

//        직접 만든 객체 정렬(스프링, 웹 개발)
//        방법1. Comparator를 구현한 익명객체 방식 1회성
        List<Student> students = new ArrayList<>();
        students.add(new Student("김진경", 30));
        students.add(new Student("경진김", 25));
        students.add(new Student("박진경", 26));
        students.add(new Student("이진경", 27));

        Collections.sort(students, (o1, o2)-> o1.getName().compareTo(o2.getName()));
        for(Student a : students){
            System.out.println(a);
        }

//        방법2. Comparable을 구현한 방식 오래된 방식 다회성? 객체를 따로 만들어야해서 유연하지 않음
//        Student객체 안에 Comparable을 implements하는 방식
//        students.sort(컴페러터);//선호
////        sort실행시 자동으로 Student안의 compareTo메서드 호출
//        Collections.sort(students, 컴페러터);//오래된 방식 이럴수도 저럴수도
        Collections.sort(students);


    }
}
class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//   Comparable의 compareTo에서는 this와 매개변수로 주어지는 객체와 비교
//    this가 앞에 있으면 오름차순, 매개변수객체가 앞에 있으면 내림차순.
    @Override
    public int compareTo(Student o) {
        //위 compareTo(Comparable)와 아래 compareTo(String)는 다름
        return this.getName().compareTo(o.getName());
    }
}
//class Student{
//    private String name;
//    private int age;
//
//    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return "{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}