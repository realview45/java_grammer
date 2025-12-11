package C01Basic;

import java.util.*;

public class C09Array {
    public static void main(String[] args) {
////        배열표현식1.배열 선언 후 값 할당 방식
////        java의 배열은 반드시 사전에 길이가 결정되어야함
////        int[] arr1 = new int[];
//        int[] arr1 = new int[5];
//        arr1[0]=10;
////        int배열의 경우 선언시 기본적으로 0으로 초기화. boolean false초기화. 참조자료형은 null로 초기화.
//        arr1[1]=20;
//        arr1[3]=40;
//        arr1[4]=50;
////        arr1[5]=60; index out of bounds 예외 발생.
////        배열표현식2.리터럴방식
//        int[] arr2 = {10,20,30,40,50};
////        배열표현식3.명시적 배열 생성방식
//        int[] arr3 = new int[]{10,20,30,40,50};
//
////        배열표현식3.활용예시 : 배열을 다른 메서드의 매개변수로 사용할 경우.
//        List<int[]> myList = new ArrayList<>();
//        int[] myArr = new int[3];
//        myList.add(new int[3]);
//        myList.add(new int[]{10,20,30,40,50});
////        myList.add({10,20,30,40,50});//사용불가(배열인지 아닌지 확인불가)

////        85,65,90으로 구성된 int배열을 선언하고, 총합과 평균을 구하시오.플레이트 코드
//        int[] arr =new int[]{85,65,90};
//        int sum=0;
//        for(int i=0;i<arr.length;i++){
//            sum+=arr[i];
//        }
//        double avg = (double)sum / arr.length;
//        System.out.println(sum);
//        System.out.println(avg);

////        배열의 최대값, 최소값 보일러 플레이트 코드(돌려쓰는 코드)(중요)
//        int[] arr = {10,20,40,12,8,17};
////        최대값을 구할때는 가장 작은 값을 설정.
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
        //1
//        for(int i=0;i<arr.length;i++){
//            max = Math.max(max,arr[i]);
//            min = Math.min(min,arr[i]);
//        }
        //2
//        for(int i=0;i<arr.length;i++){
//            if(max<arr[i]){
//                max = arr[i];
//            }
//            if(min>arr[i]){
//                min =arr[i];
//            }
//        }
//        System.out.println("max = " + max);
//        System.out.println("min = " + min);

////        배열의 자리 바꾸기
//        int[] arr = {20,10,30};
//        int temp = arr[0];
//        arr[0] = arr[1];
//        arr[1] = temp;

////        배열뒤집기
//        int[] arr = {10,20,30,40,50};//java의 원시자료형은 호환성이 떨어지고 문제가 생김
//        //1
//        //시작할 때 끝날 때 따져보기
//        int[] newArr = new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            newArr[i]=arr[arr.length-i-1];
//        }
//        //2
//        int index = 0;
//        for(int i=arr.length-1;i>=0;i--){
//            newArr[index] =arr[i];
//            index++;
//        }
//        for(int i=0;i<arr.length;i++){
//            System.out.print(newArr[i]+" ");
//        }

////        배열의 정렬
//        String test = "hello";
//
//        String[] stArr = {"abc", "aaa", "acb", "abb"};
//        Arrays.sort(stArr); //오름차순 정렬
//        System.out.println(Arrays.toString(stArr));
//        Arrays.sort(stArr, Comparator.reverseOrder()); //내림차순 정렬
//        System.out.println(Arrays.toString(stArr));
//        int[] arr = {17,12,20,10,15};
//        Arrays.sort(arr); //오름차순 정렬
////        Arrays.sort(arr, Comparator.reverseOrder()); //원시자료형은 Comparator사용 불가능

//        선택정렬 알고리즘 구현
//        구현로직 : 1)2중for문을 사용하여 index마다 최소값 찾기 2)현재위치와 자리 change
//        int[] arr = {17,12,20,10,15};
//        방법1.
//        for(int i=0;i<arr.length;i++){
//            int min = arr[i];
//            int min_idx = i;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j]<min){//최소값 찾기
//                    min = arr[j];
//                    min_idx =j;
//                }
//            }
//            int temp = arr[i];//최소값과 위치 바꿔주기
//            arr[i]=min;
//            arr[min_idx]=temp;
////            자리바꾸기 : i와 index 자리 change
//        }
////        방법2.
//        for(int i=0;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                if(arr[i] > arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//        선택정렬의 복잡도는 O(n^2). java 기본 내장 정렬함수의 복잡도 : O(n*log(n))
//        조합문제 : 모두 각기 다른 숫자의 배열이 있을 때, 만들어질 수 있는 두숫자의 조합을 출력
//        ex) (10,20), (10,30), (10,40), (10,50), (20,30), (20,40) ...
//        int[] arr ={10,20,30,40,50};
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                System.out.println(arr[i]+", "+arr[j]);
//            }
//        }

////        배열의 중복제거 : set자료구조(중복X, 순서X)활용
////        ex)10, 20, 30, 40만 남도록.
//        int[] arr = new int[]{10,30,20,30,10,40};
//        Set<Integer>mySet = new HashSet<>();
//        for(int a : arr){
//            mySet.add(a);
//        }
//        int[] answer = new int[mySet.size()];
//        int index =0;
//        for(int a : mySet){
//            answer[index] = a;
//            index++;
//        }
//        Arrays.sort(answer);
//        System.out.println(Arrays.toString(answer));
//        System.out.println(mySet);
//
////      프로그래머스 문제풀이
////        수 찾기
//
////        배열값 비교
//        int[] arr1 = {10,20,30};
//        int[] arr2 = {10,20,30};
//        System.out.println(arr1==arr2); //false
//        System.out.println(Arrays.equals(arr1,arr2));

////        배열복사
////        Arrays.copyOf(배열명, length), Arrays.copyOfRange(배열명, start, end)
//        int[] arr = {1,4,6,7,8,1,2,4,6};
//        int[] arr1 = Arrays.copyOf(arr, 4);
//        System.out.println(Arrays.toString(arr1));
//        int[] arr2 = Arrays.copyOfRange(arr, 3, 6);
//        System.out.println(Arrays.toString(arr2));

////        Arrays.fill : 배열에 모든값을 변경(채우기)
//        String[] arr = new String[5];
//        for(int i=0;i<arr.length;i++){
//            arr[i]="";
//        }
//        Arrays.fill(arr,"");

////        2차원배열의 선언과 값할당
////        {{1,2}, {1,2}, {1,2}}
////        방법1. 선언 후 할당 방식
//        int[][] arr1 = new int[3][2];
//        arr1[0][0] = 1;
//        arr1[0][1] = 2;
//        arr1[1][0] = 1;
//        arr1[1][1] = 2;
//        arr1[2][0] = 1;
//        arr1[2][1] = 2;
//
////        방법2. 리터럴 방식
//        int[][] arr2 = {{1,2}, {1,2}, {1,2}};

//        [3][4]사이즈의 2차원배열을 선언하고, 1~12까지 숫자값을 각 배열에 순차적으로 할당
//        {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}
        int[][] arr = new int[3][4];
        int num = 1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=num;
                num++;
            }
        }
        System.out.println(Arrays.deepToString(arr));
//        2차원 배열의 출력
        System.out.println(arr); //2차원 배열의 heap 주소값
        System.out.println(Arrays.toString(arr)); //각1차원배열의 heap 주소값
        System.out.println(Arrays.deepToString(arr)); //각1차원배열의 값을 출력

//        프로그래머스 - 행렬의 덧셈
//        프로그래머스 - k번쨰 수

//        가변배열 : 2차원 배열에서 각 1차원 배열의 길이가 서로 다를 수 있는 배열의 구조
        int[][] arr1 = {{1,2}, {1,2,3},{1,2,3,4}};

//        배열 전체길이는 반드시 사전할당되어야하지만, 1차원배열의 길이는 추후 할당가능
        int[][] arr2 = new int[3][];
        arr2[0] = new int[2];
        arr2[1] = new int[3];
        arr2[2] = new int[4];

    }
}
