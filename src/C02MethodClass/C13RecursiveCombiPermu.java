package C02MethodClass;

import java.util.*;

//재귀함수 활용 대표적인 알고리즘 예시 : 백트래킹, dfs 알고리즘에서 주로 사용.(또는 분할정복)
//대표적인 백트래킹 예시 : 조합과 순열에서 경우의 수 찾기
public class C13RecursiveCombiPermu {
    public static int cnt = 0;

    public static void main(String[] args) {
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.println("hello world!");
//            }
//        }
////        위 for문의 반복횟수(개수)는 동적으로 결정되지 않고, 정적으로 코딩할수밖에 없는 한계가 존재.
//        recurFor(0, 3);
//        System.out.println(cnt);


//        숫자 1,2,3,4를 가지고 만들 수 있는 2개짜리 숫자조합을 이중리스트에 담아 출력
//        n개짜리 숫자조합을 만들고 싶을 땐 구조 맞추기 바깥쪽 for문과 안쪽의 for문의 형식을 맞춰주기

//        for(int i=0;i<myList.size();i++){
//            for(int j=i+1;j<myList.size();j++){
//                List<Integer> m = new ArrayList<>();
//                temp.add(myList.get(i));
//                temp.add(myList.get(j));
//                list.add(m);
//            }
//        }
//        List<Integer> myList = new ArrayList<>();
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);

//        List<List<Integer>> list = new ArrayList<>();
////        재귀함수를 만들기 위한 for문 변형 1 2 1 3 1 4 2 3 2 4 3 4
//        List<Integer> temp = new ArrayList<>();
//        for(int i=0;i<myList.size();i++){
//            temp.add(myList.get(i));//1 2 3 4 2 3 4 3 4 4
//            for(int j=i+1;j<myList.size();j++){
//                temp.add(myList.get(j));
//                list.add(new ArrayList<>(temp));
//                temp.remove(m.size()-1);
//            }
//            temp.remove(m.size()-1);
//        }
//        int n=2;
//        System.out.println(list);
//        List<List<Integer>> doubleList = new ArrayList<>();
//        combi(new ArrayList<>(),0, myList,2, doubleList);//원본, 2개짜리 조합, 조합을 담을 이중리스트
//        System.out.println(doubleList);

        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

//        List<List<Integer>> list = new ArrayList<>();
////        재귀함수를 만들기 위한 for문 변형 1 2 1 3 1 4 2 3 2 4 3 4
//        List<Integer> temp = new ArrayList<>();
//        boolean[] visited = new boolean[myList.size()];
//        for (int i = 0; i < myList.size(); i++) {
//            temp.add(myList.get(i));
//            visited[i]=true;
//            for (int j = i + 1; j < myList.size(); j++) {
//                if(visited[i])continue;
//                visited[j]=true;
//                temp.add(myList.get(j));
//                list.add(new ArrayList<>(temp));
//                temp.remove(temp.size() - 1);
//                visited[j]=false;
//            }
//            temp.remove(temp.size() - 1);
//            visited[i]=false;
//        }
//        int n = 2;
//        System.out.println(list);
//        List<List<Integer>> doubleList = new ArrayList<>();
//        combi(new ArrayList<>(), 0, myList, 2, doubleList);//원본, 2개짜리 조합, 조합을 담을 이중리스트
//        System.out.println(doubleList);

        List<List<Integer>> doubleList = new ArrayList<>();
        permu(new boolean[myList.size()], new ArrayList<>(), myList, 2, doubleList);//원본, 2개짜리 조합, 조합을 담을 이중리스트
        System.out.println(doubleList);


        //n과 m시리즈 다 풀어보기 로또 15649,6603
    }

    public static void combi(List<Integer> temp, int start, List<Integer> myList, int n, List<List<Integer>> doubleList) {
        if (temp.size() == n) {
            doubleList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));//1 2 3 4 2 3 4 3 4 4
            combi(temp, i + 1, myList, n, doubleList);//외우고 안보고 다시 반복
            temp.remove(temp.size() - 1);
        }
    }

    public static void permu(boolean[] visited, List<Integer> temp, List<Integer> myList, int n, List<List<Integer>> doubleList) {
        if (temp.size() == n) {
            doubleList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < myList.size(); i++) {
            if(visited[i])continue;
            temp.add(myList.get(i));
            visited[i] = true;
            permu(visited, temp, myList, n, doubleList);//외우고 안보고 다시 반복
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void recurFor(int start, int end) {
        if (start == end) {
            System.out.println("hello world!");
            cnt++;
            return;
        }
        for (int i = 0; i < 3; i++) {
//            System.out.println("hello world!"); 이렇게 실행하면 3^n 형식이 아님.
            recurFor(start + 1, end);
        }
    }

}

//package javaLec.dec01;
//
//import java.util.*;
//
//public class Combi{
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
////        List<List<Integer>> doubleList = new ArrayList<>();
////        int n=2;
////        List<Integer> temp = new ArrayList<>();
////        for(int i=0;i<list.size();i++){
////            temp.add(list.get(i));
////            for(int j=i+1;j<list.size();j++){
////                temp.add(list.get(j));
////                doubleList.add(new ArrayList<>(temp));
////                temp.remove(temp.size()-1);
////            }
////            temp.remove(temp.size()-1);
////        }
////        System.out.println(doubleList);
//
//        List<List<Integer>> doubleList = new ArrayList<>();
//        combi(list,4,0,doubleList, new ArrayList<Integer>());
//        System.out.println(doubleList);
//    }
//    public static void combi(List<Integer> list, int n, int start, List<List<Integer>> doubleList, List<Integer>temp){
//        if(temp.size()==n){
//            doubleList.add(new ArrayList<>(temp));
//        }
//        for(int i = start;i<list.size();i++){
//            temp.add(list.get(i));
//            //현재의 i값은 이미 받았으므로 i+1
//            //start+1을 한다면 중복발생 i가 start보다 커지는 경우가 생김?
//            combi(list, n,i+1,doubleList,temp);
//            temp.remove(temp.size()-1);
//        }
//    }
//}
//package javaLec.dec01;
//
//import java.util.*;
//
//public class Permu {
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//
//
//        List<List<Integer>> doubleList = new ArrayList<>();
////        List<Integer> temp = new ArrayList<>();
////        boolean[] visited= new boolean[list.size()];
////
////        for(int i=0;i<list.size();i++){
////            visited[i]=true;
////            temp.add(list.get(i));
////            for(int j=0;j<list.size();j++){
////                if(visited[j])continue;
////                visited[j]=true;
////                temp.add(list.get(j));
////                doubleList.add(new ArrayList<>(temp));
////                visited[j]=false;
////                temp.remove(temp.size()-1);
////            }
////            visited[i]=false;
////            temp.remove(temp.size()-1);
////        }
////        System.out.println(doubleList);
//        permu(list,3,new ArrayList<Integer>(), doubleList, new boolean[list.size()]);
//        System.out.println(doubleList);
//    }
//    public static void permu(List<Integer> list, int n, List<Integer>temp, List<List<Integer>>doubleList,boolean[] visited){
//        if(temp.size()==n){
//            doubleList.add(new ArrayList<>(temp));
//            return;
//        }
//        for(int i=0;i<list.size();i++){
//            if(visited[i])continue;
//            visited[i]=true;
//            temp.add(list.get(i));
//            permu(list,n,temp,doubleList,visited);
//            visited[i]=false;
//            temp.remove(temp.size()-1);
//        }
//    }
//}
