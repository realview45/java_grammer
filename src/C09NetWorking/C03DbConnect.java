package C09NetWorking;

import java.sql.*;

public class C03DbConnect {
    public static void main(String[] args) throws SQLException {
//        mysql드라이버 별도 다운로드 및 추가
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String password = "test1234";
        Connection myConnection = DriverManager.getConnection(url, userName, password);
        System.out.println(myConnection);
//        Statement객체에 쿼리를 담아 db에 전송
        Statement st = myConnection.createStatement();
        ResultSet result = st.executeQuery("select * from post2");//(안중요)jdbc안의 return값이 java.sql안의 ResultSet이라는 객체에 담겨옴
//        next를 통해 데이터를 1행씩 read
        //iterator처럼 작용
        while(result.next()){
            System.out.println(result.getInt("id"));
            System.out.println(result.getString("title"));
            System.out.println(result.getString("contents"));
        }
    }
}
