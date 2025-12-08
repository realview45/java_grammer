package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C01InputOutput {
    public static void main(String[] args) throws IOException {

//        출력 : System.out을 통해 콘솔(터미널창)출력
//        System.out.println(20); //println은 줄바꿈있는 출력. 2)입출력은 모두 문자열로 진행
//        System.out.print("hello world1"); //print는 줄바꿈이 없는 출력
//        System.out.print("hello world2");

        //쓰지말라구리
//        입력1 : Scanner클래스 - 입력을 위한 클래스로서 바이트단위 입력처리. System.in-키보드입력
//        Scanner myScanner = new Scanner(System.in);
//        String input = myScanner.nextLine(); //입력받은 데이터를 한줄로 읽어서, String으로 리턴
//        System.out.println("사용자 입력 사항 : " + input);

//        아래와 같이 입력값이 주어졌을때 처리 방법
//          Scanner myScanner = new Scanner(System.in);
//          String input1 = myScanner.nextLine();
//          String input2 = myScanner.nextLine();
//          int input3 = Integer.parseInt(myScanner.nextLine()); // 입력받은 문자열을 직접 형변환(파싱)추천
//          int input4 = myScanner.nextInt(); //줄바꿈 상황에서 지엽적으로 신경쓸 일이 있음
//          System.out.println("input1 = " + input1);
//          System.out.println("input2 = " + input2);
//          System.out.println("input3 = " + input3);
//          System.out.println("input4 = " + input4);

          /*
          abc
          bcd
          2
          3
           */

//        입력2 : BufferedReader : 1)버퍼를 활용하여 더 좋은 성능 2)InputStreamReader는 바이트대신 문자단위로 입력
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input2 = br.readLine(); //입력받은 데이터를 한줄씩 read
//        System.out.println("사용자 입력 사항 : " + input2);

//        입력값 : abc bcd efg
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input2 = br.readLine();
//        String[] arr = input2.split(" ");
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//        close()는 메모리회수.외부입출력장치와 연계된 코드이므로, GC(가비지 컬렉터)의 대상이 아님.
//        br.close();

//      BufferedReader + StringTokenizer//안써도 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
//      StringTokenizer를 통해 공백을 기준으로 문자열을 하나씩 잘라서 내부에 토큰화
        StringTokenizer st = new StringTokenizer(input);
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        br.close();//그냥 써도됨

    }
}
