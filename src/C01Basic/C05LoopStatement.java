package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C05LoopStatement {
    public static void main(String[] args) throws IOException {
////        while문의 조건식에 변화를 주지 않으면 while문은 기본적으로 무한루프
//        int a =0;
////        아래 while문은 10번 반복되는 반복문
//        while(a<10){
//            System.out.println("hello world");
//            a+=1;
//        }
////        while문을 활용하여 2~10까지 출력
//        int b = 2;
//        while(b < 11){
//            System.out.println(b);
//            b++;
//        }
//        int c = 2;
//        while(true){
//            System.out.println(c);
//            c++;
//            if(c==11){
//                //break키워드를 통해 가장 가까이에 있는 반복을 즉시종료
//                break;
//            }
//        }
////        반복되는 도어락키 예제
////        만약 비밀번호를 맞추면 즉시 종료 -> 문이 열렸습니다 출력
////        5회입력을 초과할때까지 맞추지 못하면 종료 -> 비밀번호5회초과 출력
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String answer = "1234";
//        int cnt =0;
//        while(true){
//            String input = br.readLine();
//            if(input.equals(answer)){
//                System.out.println("문이 열렸습니다.");
//                break;
//            }
//            else{
//                System.out.println("비밀번호가 틀렸습니다.");
//            }
//            cnt++;
//            if(cnt == 5){
//                System.out.println("비밀번호 5회초과");
//                break;
//            }
//        }

////        입력한 숫자의 구구단 단수 출력 ex)2를 입력 -> 2X1=2 2X2=4 ... 2X9=18
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        while(true){
//            int n = Integer.parseInt(br.readLine());
//            int dan = 1;
//            while(dan < 10) {
//                System.out.println(n + "X" + dan + "=" + (n * dan));
//                dan++;
//            }
//        }

////        do while문 : 무조건 1번은 실행되는 while문 잘안쓰임
//        int a = 100;
//        do{
//            System.out.println("hello world");
//            a++;
//        }while(a<5);
//        while(a<5){
//            System.out.println("hello world");
//        }
//
////        for문 : 초기식, 조건식, 증감식이 모두 포함돼있는 반복문
//        for(int i=100;i<10;i++){
//            System.out.println("hello world");
//        }

////        1~10중에 홀수만 출력하기
//        for(int i=1;i<11;i++){
//            if(i%2==1) {
//                System.out.println(i);
//            }
//        }

//        continue: 반복문의 증감, 조건식으로 이동하는 명령어. 즉, countinue하위의 코드를 더이상 실행하지 않음.
        for(int i=1;i<11;i++){
            if(i%2==0) {
//                continue는 코드의 직관성과 가독성을 위해 사용.
                continue;
            }
            System.out.println(i);
        }

    }
}
