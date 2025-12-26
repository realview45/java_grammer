package C09NetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C02WebServerGet {
    public static void main(String[] args) throws IOException {
        //        사용자 : 크롬을 통해 http://localhost:8080?id=1 요청 get요청
        //        서버 : ""hello world java + id" 문자열을 응답 (http응답문서조립필요)
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버시작");
        while(true){
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuffer sb = new StringBuffer();
            //소켓안에 사용자의 요청정보가 담겨있는데 이제 까보겠다.
            String line = br.readLine();
            while(line != null && !line.isEmpty()){
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String infos = firstLine.split(" ")[1];
            String id = "";
            if(infos.contains("?")){
                id = infos.split("=")[1];
            }
            //사용자의 요청 1.get 2.id
            System.out.println(requestString);                              // 동적코딩
            String response = "HTTP/1.1 200 OK\r\n\r\n" + "hello world java" + id;
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}
