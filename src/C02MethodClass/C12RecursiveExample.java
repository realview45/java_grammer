package C02MethodClass;

import java.util.Arrays;

//재귀함수 대표적인 기본 예시 : 누적합계, 팩토리얼, 피보나치수열 등 -> 모두 재귀를 푸는 것을 권고하지 않음.
public class C12RecursiveExample {
    public static void main(String[] args) {
////        1~10까지 누적합계(for문 활용)
//        int total =0;
//        for(int i=1;i<11;i++){
//            total+=i;
//        }
//        System.out.println(total);

////        1~10까지 누적합계(재귀함수)
//        int total2 = sumAcc(1,10);
//        System.out.println(total2);

////        1~5까지 누적곱(팩토리얼) - 재귀함수
//        int total = 1;
//        for(int i=1;i<6;i++){
//            total *= i;
//        }
//        System.out.println(total);
//
//        int total2 =factorial(5);
//        System.out.println(total2);

////        피보나치 수열 f(n) = f(n-1) + f(n-2)
////        1 1 2 3 5 8 13 21 34 ...
////        피보나치 수열의 10번째 값은?
////        풀이1 : for문만을 이용
//        int num1 = 1;
//        int num2 = 1;
//        int next = 0;
//        int n = 5;
//        for(int i=3;i<n+1;i++){
//            next = num1 + num2;
//            num1 = num2;
//            num2 = next;
//        }
//        System.out.println(next);

////        풀이2. dp알고리즘(기억하기-메모이제이션 알고리즘)을 활용한 풀이법.
////        점화식 : f(n) = f(n-1) + f(n-2) 점화식 세우는 것이 필수는 아님
//        int[] dp = new int[10];
//        dp[0] = 1;
//        dp[1] = 1;
//        for(int i= 2; i<10;i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        System.out.println(Arrays.toString(dp));

//888

////        풀이3 : 재귀함수를 이용한 풀이법
//        System.out.println(fibonacci(10));

    }
    public static int sumAcc(int start, int end){
        if(start > end){
            return 0;
        }
        return start+sumAcc(start+1, end);
    }
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n * (factorial(n-1));
    }
    public static int fibonacci(int n){
        if(n<=2){
            return 1;
        }
        return fibonacci(n-1)+ fibonacci(n-2);
    }
    public static int fibonacci(int n,int[] dp){
        if(n<=2){
            return 1;
        }
        else if(dp[n]!=0){
           return dp[n];
        }
        return dp[n]= fibonacci(n-1) + fibonacci(n-2);
    }
}