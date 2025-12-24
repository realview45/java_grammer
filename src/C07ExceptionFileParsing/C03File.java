package C07ExceptionFileParsing;

//io패키지
import jdk.dynalink.StandardOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class C03File {
    public static void main(String[] args) throws IOException {
//        버퍼에 모아                                   문자체게입력(키보드를 통한 입출력)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //콘솔입력, 파일입력도 할 수 있음
        //파일입출력 다른것씀

////        파일에서 읽기 : IO패키지
//        BufferedReader br2 = new BufferedReader(new FileReader("src/C07ExceptionFileParsing/test.txt"));
//        //버퍼링처리를 해서 읽어오겠다
//        String line =br2.readLine();
//        while(line!=null){
//            System.out.println(line);
//            line = br2.readLine();
//        }

////        파일에서 읽기 : NIO패키지(스레드 논블로킹)(io패키지(스레드 블로킹)보다 빠르다)
//        Path filePath = Paths.get("src/C07ExceptionFileParsing/test.txt");
////        readString : 문자열전체를 통째로 read
//        String st1 = Files.readString(filePath);
//        System.out.println(st1);
////        readAllLines : 문자열을 라인별로 split하여 list형태로 저장
//        List<String> st2 = Files.readAllLines(filePath);
//        System.out.println(st2);

//        파일에 문자열 쓰기
        Path filePath = Paths.get("src/C07ExceptionFileParsing/test.txt");
//        Files.write(filePath, "홍길동0".getBytes(), StandardOpenOption.CREATE_NEW);//새로만들기 파일삭제 후
        Files.write(filePath, "홍길동1\n".getBytes(), StandardOpenOption.WRITE);//덮어쓰기
        Files.write(filePath, "홍길동1\n".getBytes(), StandardOpenOption.APPEND);//추가모드


    }
}
