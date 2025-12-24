package C07ExceptionFileParsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class C02ExceptionAdvance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        의도된 예외 강제 발생 : 특정 시점에 프로그램을 강제중지시키기 위한 목적 //스프링에서 매우 흔함!!!중요!!! unchecked 처리
       //String name =sc.nextLine();
        System.out.println("email입력");
        String email =sc.nextLine();
        System.out.println("password입력");
        String password = sc.nextLine();
        try{
            register(email, password);
        }catch(IllegalArgumentException e){
            System.out.println("회원가입중 에러발생");
            System.out.println(e.getMessage());
            return;
        }


//        checked exception의 처리방법
//        방법1. throws를 통해 checked 예외처리를 위임(throws)받고, main에서도 throws(시스템 위임) (권장X)
//        String text = fileRead("src/C07ExceptionFileParsing/test.txt");
//        System.out.println(text);
//        방법2. throws를 통해 checked 예외처리를 위임(throws)받고, 호출하는 쪽에서 예외처리(trycatch)
//        try {
//            String text = fileRead("src/C07ExceptionFileParsing/test.txt");
//            System.out.println(text);
//        }catch(IOException e){
////            사용자에게 메시지 전달
//            System.out.println("파일 처리과정에서 에러가 발생했습니다.");
//            e.printStackTrace();
//        }
//        방법3. checked예외를 try/catch하여 unchecked 예외 강제 발생. (DB 롤백을 목적)흔함
        try {
            String text = fileRead("src/C07ExceptionFileParsing/test.txt");
            System.out.println(text);
        }catch(RuntimeException e){
//            사용자에게 메시지 전달
            System.out.println("파일 처리과정에서 에러가 발생했습니다.");
            e.printStackTrace();
        }
    }
    //3
    static String fileRead(String path){
        // 1 2위임받고 부분
//    static String fileRead(String path) throws IOException {
        Path filePath = Paths.get(path);
        String text = null;
        try{
            text = Files.readString(filePath);//checked 예외 발생예상
        } catch(IOException e){
            throw new RuntimeException(e); //checked는 롤백기준 아니므로 unchecked 예외를 터뜨려 롤백시킴
        }
        return text;
    }


    // 1 2위임받고 부분
//    static String fileRead(String path) throws IOException {
//        Path filePath = Paths.get(path);
//        String text = Files.readString(filePath);
//        return text;
//    }

    static boolean register(String email, String password){//password길이가 짧거나 이메일이 중복이다 에러를 던님
        boolean check = false;
        if(password.length() >= 10){
            check = true;
        }else{
//            예외를 강제 발생시킴으로써 이 시점에서 해당 메서드 강제 종료
//            예외는 기본적으로 메서드를 호출한 쪽으로 전파
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
        System.out.println("DB에 저장되는 코드");
        return check;
    }
}
