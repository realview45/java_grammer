package C05AnonymousLambda;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {//꼭 알아야함 java8이후의 문법
    public static void main(String[] args) {
//        int[] arr = {20,10,4,12};
////    전통적인 방식의 데이터 접근방법 : 메모리주소접근
//        for (int i=0;i<arr.length;i++){
//            arr[i] +=10;
//            System.out.println(arr[i]);
//        }
////        함수형 프로그래밍 방식 : 데이터와 객체 중심이 아닌, (사본)입력에 따른 (연산작업포함)출력만 존재하는 코딩스타일
////        streamApi : java에서 함수형 프로그래밍을 지원하는 라이브러리
////        foreach는 스트림의 각 요소를 하나씩 소모하면서 동작을 수행
//        Arrays.stream(arr).forEach(a-> System.out.println(a));
//
//////        스트림의 생성 : .stream()
//        List<String> myList = new ArrayList<>();
//        myList.add("java");
//        myList.add("python");
//        myList.add("C++");
//        Stream<String> stream1 = myList.stream();//원본을 가지고 사본작업을 할수있는 stream 객체 만들기
//        String[] myArr = {"java", "python", "C++"};
//        Stream<String> stream2 = Arrays.stream(myArr);
//
////        원시자료형을 위한 stream객체가 별도로 존재
//        int[] intArr = {10,20,30,40,50};
//        IntStream stream3 = Arrays.stream(intArr);

////        stream의 중개연산(변환) : filter, map, sorted, distinct, mapToInt
//        int[] intArr = {10,10,30,40,50};
////        filter : 특정기준으로 대상을 필터링하여 새로운 스트림을 반환하는 중개연산
////        sum : 스트림의 요소를 하나씩 소모하여 총합을 구하는 메서드
//        int total = Arrays.stream(intArr).filter(a -> a>=30).sum();
//        System.out.println(total);
////        map : 기존의 스트림을 조작하여 새로운 스트림을 반환
//        int total2 = Arrays.stream(intArr).map(a->a*a).sum();
//        System.out.println(total2);
////        distinct : 중복제거
//        int total3 = Arrays.stream(intArr).distinct().sum();
//        System.out.println(total3);
////        sorted : 정렬
//        int[] sortedArr = Arrays.stream(intArr).sorted().toArray();
//        System.out.println(Arrays.toString(sortedArr));
////        mapToInt : intStream형태로 변환해주는 map
//        String[] stArr = {"java", "python", "c++"};
////        String[] stArr2 = Arrays.stream(stArr).map(a-> a + "hello").toArray();
//
//        int totalLength = Arrays.stream(stArr).mapToInt(a->a.length()).sum();

//        int[] arr = {1,2,3,4,5,6};
////        실습1) arr에서 홀수만 담은 배열을 생성 후 배열출력
//        int[] newArr1 = Arrays.stream(arr).filter(a->a%2==1).toArray();
////        실습2) arr에서 홀수만 걸러서 해당 홀수의 제곱값을 담은 배열을 출력
//        int[] newArr2 = Arrays.stream(arr).filter(a->a%2==1).map(a-> a * a).toArray();
////        실습3) arr에서 홀수만 걸러 제곱값을 구하고, 해당숫자값을 오름차순한 순서로 배열을 출력
//        int[] sortedArr = Arrays.stream(arr).filter(a->a%2==1).map(a-> a * a).sorted().toArray();
//        System.out.println(Arrays.toString(sortedArr));

////        stream의 소모 : foreach(출력), sum(합계), count, max, min, reduce(누적연산), findFirst(스트림의 첫번째 값 리턴)
//          int[] intArr = {10,20,30,40};
//          Arrays.stream(intArr).forEach(a-> System.out.println(a));
//          int total = Arrays.stream(intArr).sum();
//          System.out.println(total);
//          long count = Arrays.stream(intArr).count();
//          System.out.println(count);
////          optional객체 : 값이 있을수도 있고, 없을수도 있음을 명시한 객체
//          int max = Arrays.stream(intArr).max().getAsInt();
//          int min = Arrays.stream(intArr).min().getAsInt();

////          reduce : 누적연산 -> reduce(초기값, 연산식)
//        int[] intArr = {10,20,30,40};
//        int accSum = Arrays.stream(intArr).reduce(0, (a, b)->a+b);
//        System.out.println(accSum);
//        int accMultiply = Arrays.stream(intArr).reduce(0, (a, b)->a+b);
//        System.out.println(accMultiply);
//        String[] stArr = {"java","python","c++"};
//        String result = Arrays.stream(stArr).reduce("", (a,b)->a+b);
//        System.out.println(result);
////        findFirst : 첫번째 요소 반환
//        String firstValue = Arrays.stream(stArr).filter(a->a.length()>=5).findFirst().get();
//        System.out.println(firstValue);
//
//        Map<String, Integer> myMap = new HashMap<>();
//        myMap.put("hello", 10);
//        myMap.put("java", 20);
//        String firstKeyValue = myMap.keySet().stream().findFirst().get();
//        System.out.println(firstKeyValue);

//        배열로 변환시 주의사항 (안중요) : 제네릭의 타입소거 -> 자바의 런타임시점에 <String>과 같은 제네릭의 타입이 제거되는 현상
//        제네릭의 타입소거로 인해, toArray를 통해 새로운 String배열을 곧바로 만들어내는 것은 불가.
//        String[] stArr = {"hello", "java", "world"};
////        <제네릭>
//        String[] answer = Arrays.stream(stArr).filter(a->a.length()>=5).toArray(a->new String[a]);//a안에는 배열의 길이가 담김
////        메소드 참조 : 하나의 메소드만을 호출하는 경우에 매개변수를 제거한 형식
//        String[] answer2 = Arrays.stream(stArr).filter(a->a.length()>=5).toArray(String[]::new);//a안에는 배열의 길이가 담김
////        형식-"클래스명::메소드명", 조건-하나의 메소드(실행문)만을 호출하는 경우
//        Arrays.stream(stArr).forEach(a-> System.out.println(a));
//        Arrays.stream(stArr).forEach(System.out::println);

//        streamapi 실습)
        List<Student> myList = new ArrayList<>();
        myList.add(new Student("kim",20));
        myList.add(new Student("lee",40));
        myList.add(new Student("park",33));
        myList.add(new Student("choi",22));
//        1)모든 객체의 평균나이(average합수)
        double avg = myList.stream().mapToInt(a->a.getAge()).average().getAsDouble();//이렇게하면안됨
        System.out.println(avg);
//        2)정렬을 통한 가장 나이 어린 사람 찾기(sorted) + findFirst
        Student student = myList.stream().sorted((o1,o2)->o1.getAge()-o2.getAge()).findFirst().get();
        System.out.println(student);
//        3)30대인 사람들만의 이름만 모아서 새로운 String배열에 담기(map활용)
        String[] nameStArr = myList.stream().filter(a->a.getAge()>=30&&a.getAge()<40).map(a->a.getName()).toArray(a->new String[a]);
        System.out.println(Arrays.toString(nameStArr));

////        Optional객체 : 특정객체에 값이 없을지도(null) 모른다는 것을 명시적으로 표현한 객체 (중요)
//        String st1 = null;//?있는지 없는지 모를때
//        if(st1==null){
//            System.out.println("값이 없습니다.");
//        }else {
//            System.out.println(st1.length());
//        }
//        Optional<String> opt1 = Optional.ofNullable(null);//스프링 중요
//        if(opt1.isPresent()){
//            System.out.println(opt1.get().length());
//        }else {
//            System.out.println("값이 없습니다.");
//        }

////        Optional객체 생성 방법 3가지.
//        Optional<String> opt1 = Optional.empty(); // 비어있는 Optional객체 생성
//        Optional<String> opt2_1 = Optional.ofNullable(null);// 비어있는 Optional객체 생성
//        Optional<String> opt2_2 = Optional.ofNullable("hello");// 값이 있는 Optional객체 생성
//        Optional<String> opt3 = Optional.of("hello");//값이 있는 Optional객체 생성

////        Optional객체 처리 방법 4가지.
////        방법1. isPresent()로 확인후에 get()
//        if(opt1.isPresent()){
//            System.out.println(opt1.get());
//        }else{
////            System.out.println(opt1.get()); //예외(에러)발생
//            System.out.println("값이 없습니다.");
//        }
////        방법2. orElse() : 값이 있으면 있는 값 return, 없으면 지정한 값 return//많이 안씀
//        System.out.println(opt2_1.orElse("값이 없습니다."));
//        System.out.println(opt2_2.orElse("값이 없습니다."));
//
////        방법3. orElseGet() : 값이 있으면 있는 값 return, 없으면 람다함수 실행//잘 안씀
//        System.out.println(opt2_1.orElseGet(()->new String("값이 없습니다.")));

//        방법4. orElseThrow() - 가장많이사용(중요!), 값이 있으면 있는 값 return,없으면 지정한 예외(에러) 강제발생
//        왜 에러를 터뜨리나? -> 강제중단
//         웹개발에서 값을 입력하는 사용자에게 적절한 메시지 전달 목적과 의도된 코드중단을 목표로 강제로 예외(에러)를 발생시키는 경우는 매우  일반적.
//        왜 의도된 에러를 터뜨리나? -> 적절한 문구, 적절한 예외(중요)
//        System.out.println(opt2_1.orElseThrow(()-> new RuntimeException("값이 없습니다.")));
//        System.out.println(opt2_1.get()); //의도치않은 에러발생. (지양해야할 에러)

////        optional객체 처리 실습1)
//        List<Student> studentList = new ArrayList<>();
////        studentList.add(new Student("kim",20));
////        studentList.add(new Student("lee",40));
////        studentList.add(new Student("park",33));
////        studentList.add(new Student("choi",22));
//        OptionalDouble optionalAvg = studentList.stream().mapToInt(a->a.getAge()).average();
////        optional객체 처리방법1.
//        double value1 = 0;
//        if(optionalAvg.isPresent()){
//            value1 = optionalAvg.getAsDouble();
//            System.out.println(value1);
//        }else {
//            System.out.println("값이 없습니다.");
//        }
////        optional객체 처리방법2. 더 많이 쓰는 방법
//        double value2 = studentList.stream().mapToInt(a->a.getAge()).average().orElseThrow(()-> new NoSuchElementException("값이 없습니다."));
//        System.out.println(value2);

////        optional객체 처리 실습2)
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student("kim",20));
//        studentList.add(new Student("lee",40));
//        studentList.add(new Student("park",33));
//        studentList.add(new Student("choi",22));
//
//        System.out.println("조회하고자 하는 student의 index번호를 입력해주세요");
//        Scanner sc = new Scanner(System.in);
//        int number = Integer.parseInt(sc.nextLine());
//        Optional<Student> s1; //Optional클래스로 wrapping
//        if(studentList.size() <= number || number < 0){
//            s1 = Optional.empty(); //객체 생성
//        }else {
//            s1 = Optional.of(studentList.get(number));//((옵셔널에는 아무거나 올수 있나보다))
//        }
//        System.out.println(s1.orElseThrow(()-> new NoSuchElementException("없는 회원입니다.")));

        List<Student> list = new ArrayList<>();
        list.add(new Student("kim",20));
        list.add(new Student("lee", 30));
        list.add(new Student("park",33));
        list.add(new Student("choi",22));

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        Optional<Student>s1;
        if(list.size()<=num||num<0){
            s1 = Optional.empty();
        }else {
            s1= Optional.of(list.get(num));
        }
        System.out.println(s1.orElseThrow(()-> new NoSuchElementException("없는 회원입니다.")));
    }
}
