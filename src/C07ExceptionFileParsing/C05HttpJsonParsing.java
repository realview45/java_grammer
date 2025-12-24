package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
//json실습
public class C05HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
//        외부에서 데이터를 받아 java의 객체로 변환
//        외부api요청을 하기 위한 라이브러리 HttpClient, RestTemplate, RestClient
//        HttpClient-java내장클래스.
//        RestTemplate, RestClient - 스프링에서 가장 많이 사용하는 클래스.
        HttpClient client = HttpClient.newHttpClient();//중요X
        //데이터 달라고 요청
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET().build();

        HttpResponse<String> response = //응답이 담김
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String data = response.body();
        System.out.println(data);

        ObjectMapper o1 = new ObjectMapper();
//        객체로 파싱
        Post p1 = o1.readValue(data, Post.class);
        System.out.println(p1);

//        리스트형식의 객체로 파싱
        HttpClient client2 = HttpClient.newHttpClient();//중요X
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/"))
                .GET().build();
        HttpResponse<String> response2 = //응답이 담김
                client2.send(request2, HttpResponse.BodyHandlers.ofString());
        String data2 = response2.body();

        JsonNode jsonNodes =o1.readTree(data2);
        List<Post>postList =new ArrayList<>();
        for(JsonNode j : jsonNodes){
            postList.add(o1.readValue(j.toString(),Post.class));
        }
        for(Post p : postList){
            System.out.println(p);
        }
    }
}
//형변환 시킬 객체 정의 getter와 기본생성자 필수
class Post{
    private long userId;
    private long id;
    private String title;
    private String body;
    public Post(){

    }
    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}