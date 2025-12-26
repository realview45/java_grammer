package C09NetWorking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01WebServerGet {
    public static void main(String[] args) throws IOException {
//        사용자 : 크롬을 통해 http://서버url 요청 get요청 (아무url 들어가서 enter)(http요청문서조립필요)
//        서버 : ""hello world java" 문자열을 응답 (http응답문서조립필요)
//        소켓이란 서버와 사용자가 통신을 하기위한 네트워크통신의 끝점을 나타내는 개념.
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버시작");
        while(true){//서버 프로그램은 꺼지지 않고 사용자가요청할때마다 응답줘야하구리
                            // http://localhost:8080 get요청 body가 없구리 사용자위치 문서스펙기본스펙 웹브라우저가 대신 문서조립구리
                            // post요청 화면만들어야함(프론트엔드)(회원가입)문서 (header/body)http문서 사용자로부터 입력받는 형식 툴사용 -> postman
                            // http://localhost:8080?id=2 게시글 목록조회
//            accept : 사용자의 연결 요청을 수락
//            socket객체 안에는 사용자가 보내온 http요청문서 및 사용자정보(ip등)
            Socket socket = serverSocket.accept();
//            사용자에게 서버의 응답메시지를 전송
                                        //200 400 404는 개발자들끼리 주고받는 의미있는 코드구리
            String response = "HTTP/1.1 200 OK\r\n\r\n" + "hello world java";
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
//            flush란 일반적으로 변경사항을 확정하는 것을 의미 소켓을 닫는다구리
            socket.getOutputStream().flush();
//            자바시스템의 영역을 벗어나므로 명시적으로 메모리 낭비 막기위해 close구리
            socket.close();
        }
    }
}
