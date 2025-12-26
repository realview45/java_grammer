package C09NetWorking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.*;
//WebServer와 DB에 대한 연결
public class C03WebServerDb {
    public static void main(String[] args) throws IOException, SQLException {
        //        사용자 : 크롬을 통해 http://localhost:8080?id=1 요청 get요청
        //        서버 : DB에서 조회한 결과값을  문자열형식으로 응답 1)일반문자열 2)json
        ServerSocket serverSocket = new ServerSocket(8080);

        //db연결
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String password = "test1234";
        Connection myConnection = DriverManager.getConnection(url, userName, password);
        Statement st = myConnection.createStatement();


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
            String id = "";//요청정보에서 id를 받아온다음
            if(infos.contains("?")){
                id = infos.split("=")[1];
            }


            ResultSet result = st.executeQuery("select * from post2 where id=" +"\'"+ id +"\'");//(안중요)jdbc안의 return값이 java.sql안의 ResultSet이라는 객체에 담겨옴
            //db를 조립
            //📍 http 문서 구성(스펙) : Start Line(필수), Header, Empty Line, Body
            // <Start Line>
            // - HTTP/1.1 : http 문서의 버전
            // - 400 : 문서의 상태가 정상이라면 200, 에러가 난다면 각 에러에 맞게 400, 404등 작성
            // - Forbidden : 숫자를 의미하는 수식 문구로 정상이면 OK, 그 외엔 에러에 맞게 작성
            Post post = null;
            while(result.next()){
                post = new Post(result.getLong("id"),
                        result.getString("title"),
                        result.getString("contents"));
//                response += "id : " + result.getInt("id");
//                response += "title : " + result.getString("title");
//                response += "contents : " + result.getString("contents");
            }
            System.out.println(post);
            ObjectMapper objectMapper =new ObjectMapper();
            String jsonPost = objectMapper.writeValueAsString(post);//직렬화
            String response = "HTTP/1.1 200 OK\r\n" +//startline
                    "Content-Type: application/json; charset=UTF-8" + "\r\n\r\n" +//headers
                    jsonPost; // + "hello world java" + id;//body
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}
//getter를 왜 넣어야하는가 reflection 기술(안중요)
class Post{
    private long id;
    private String title;
    private String contents;

    public Post(){

    }
    public Post(long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}