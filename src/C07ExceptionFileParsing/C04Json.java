package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class C04Json {
    public static void main(String[] args) throws IOException {
////      외부의 json파일을 java의 클래스(객체) 변환 : json파싱(역직렬화)
        Path filePath = Paths.get("src/C07ExceptionFileParsing/myjson1.json");
////        readString : 문자열전체를 통째로 read
        String st1 = Files.readString(filePath);
        System.out.println(st1);
//
////        Jackson라이브러리(spring(웹개발위한 각종 자바라이브러리(패키지까지 포함)묶음)에는 기본적으로 탑재. java에서는 별도로 추가)의
////        ObjectMapper클래스를 통한 객체로 파싱
        ObjectMapper o1 = new ObjectMapper();
//////        Map으로 일괄적으로 String, String으로 파싱 (잘사용X)
////        Map<String, String> myMap = o1.readValue(st1, Map.class);
////        System.out.println(myMap);
////        System.out.println(myMap.get("name"));
////        내가 직접 만든 객체로 파싱 형식과 클래스의 구조가 딱 맞아야함
        Student myStudent = o1.readValue(st1, Student.class);
        System.out.println(myStudent);
//        System.out.println(myStudent.getId());

////        List형식으로 주어지는 json파싱 : 트리구조의 JsonNode(자료구조)로 변환
//        Path filePath = Paths.get("src/C07ExceptionFileParsing/myjson1.json");
//////        readString : 문자열전체를 통째로 read
//        String st1 = Files.readString(filePath);
//        ObjectMapper o1 = new ObjectMapper();
//        JsonNode jsonNodes = o1.readTree(st1);//트리로 변환 readTree()잘안씀 readValue()
//        List<Student> studentList = new ArrayList<>();
//        for(JsonNode j : jsonNodes){//json 객체 하나
//            Student s1 = o1.readValue(j.toString(), Student.class);//객체로읽어오기
//            studentList.add(s1);
//        }
//
//        System.out.println(st1);




////        json직렬화 : 객체 -> json.
//        ObjectMapper o1 = new ObjectMapper();
//        Student s1 = new Student(1, "h1", "1", "seoul");
//        String result = o1.writeValueAsString(s1);//readValue() writeValueAsString() 기억
//        System.out.println(s1);
//        System.out.println(result);

    }
}
//실제 값의 setting은 private변수이므로 직접접근 불가.
//java의 reflection 기술을 통해 런타임시점에 private 변수도 직접 접근 가능.
//다만, 필드값을 유추할 수 있도록 (getter 메소드+기본생성자)를 생성해야함.
class Student{
    private long id;
    private String name;
    private String classNumber;
    private String city;

    public Student(long id, String name, String classNumber, String city) {
        this.city = city;
        this.classNumber = classNumber;
        this.name = name;
        this.id = id;
    }

    public Student(){

    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}