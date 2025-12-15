package C01Basic;

import java.util.regex.Pattern;

public class C08String {
    public static void main(String[] args) {
////        String 선언방법 2가지
////        객체선언방식
//        String st1 = new String("hello world");
//        String st2 =new String("hello world");
////        리터럴방식 : String pool을 사용하는 방식(java에서 추천)
//        String st3 = "hello world";
//        String st4 = "hello world";
//        System.out.println(st1==st2);//false
//        System.out.println(st3==st4);//true;
//        System.out.println(st1==st3);//false
//
////        참조자료형의 비교는 ==을 지양
//        System.out.println(st1.equals(st3));//true

////      .equals : 힙메모리의 문자열을 가져와서 equal 관계를 비교
//        String st1 = "hello1";
//        String st2 = "Hello1";
//        System.out.println(st1.equals(st2));//false
//        System.out.println(st1.equalsIgnoreCase(st2));//true

//        length : 문자열의 길이 출력
//        String st1 = "hello1 world1 java1";
//        System.out.println(st1.length());
//        int[] arr =new int[10];
//        System.out.println(arr.length);
////        charAt(n) : 특정 index의 문자(char)값을 리턴
//        char ch1 = st1.charAt(7);
//        System.out.println(ch1);
//        a의 개수가 몇개인지 출력
//        int cnt =0;
//        for(int i=0;i<st1.length();i++){
//            if(st1.charAt(i)=='a'){
//                cnt++;
//            }
//        }
//        toCharArray:String문자열을 char배열로 변환
//        char[] arr = st1.toCharArray();
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]=='a'){
//                cnt++;
//            }
//        }
//
//        for(char a : st1.toCharArray()){
//            if(a=='a'){
//                cnt++;
//            }
//        }
//        System.out.println("a의 개수: " + cnt);

////        indexOf(문자열) : 특정 문자열의 위치(index) 반환. 가장 먼저 나오는 문자열의 위치 반환.
//        String st1 = "hello java java";
//        System.out.println(st1.indexOf("java"));
//        System.out.println(st1.lastIndexOf("java"));
//        System.out.println(st1.contains("hello"));//true
//        System.out.println(st1.contains("world"));//false

////        문자열 더하기 : +=사용. 성능측면에서는 추후 배울 StringBuffer, StringBuilder사용
//        String st1 = "hello";
//        st1 += "world";
//        st1 += '1'; //String에 char를 더하면 String으로 변환

//        프로그래머스 - 플랫폼 사용법 (나머지 구하기)

//        프로그래머스 - 특정 문자 제거하기

////        substring(a,b) : a이상 b미만의 index의 문자를 잘라 문자열로 반환
//        String st1 = "hello world";
//        System.out.println(st1.substring(0, 5));
//        System.out.println(st1.substring(6, st1.length()));

//        프로그래머스 - 가운데 글자 가져오기

////        trim, strip : 문자열 양쪽 끝의 공백 제거
//        String st1 = " hello world ";
//        String st2 = st1.trim();
//        String st3 = st1.strip();//성능이 좀더좋음 뭔쓰든 상관없음
//        System.out.println(st2);
//        System.out.println(st2);

////        toUpperCase : 모든 문자열을 대문자로 변환, toLowerCase : 소문자로 변환.
//        String st1 = "Hello";
//        String st2 = st1.toUpperCase();
//        String st3 = st1.toLowerCase();
//        System.out.println(st2);
//        System.out.println(st3);
//        System.out.println(st1);

////        replace(a,b) : a문자열을 b문자열로 대체
//        String st1 = "hello world world";
//        String st2 = st1.replace("world","java");
//        System.out.println(st2);
//        System.out.println(st1);
//          replaceAll(a,b) : replace와 사용법 동일. 정규표현식을 쓸 수 있는 점이 차이점.
//        String st1 = "01abC1223   한글123";
////        한글제거 [가-힣]
//        String answer1 =st1.replaceAll("[가-힣]","");
//        System.out.println(answer1);
////        알파벳제거
//        String answer2 =st1.replaceAll("[A-Za-z]","");
//        System.out.println(answer2);
////        공백제거
//        String answer3 =st1.replaceAll(" ","");
//        System.out.println(answer3);
//        String answer4 =st1.replaceAll("\\s+","");//공백을 제거
//        System.out.println(answer4);

////        전화번호검증(외울필요X)
//        String number = "010-34-1234";
//        boolean check = number.matches("^\\d{3}-\\d{4}-\\d{4}$");
//        if(check==false){
//            System.out.println("형식이 잘못됐습니다. 다시 입력해주세요.");
//        }
////        이메일 검증 사용자가 실수했을 가능성을 염두에 두고 검증
//        String email = "abc1234@naver.com";
//        boolean check = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
//        System.out.println(check);

//        놓쳣다
////        split : 특정문자를 기준으로 잘라서 문자배열로 만드는 것.
//        String a = "a:b:c:d";
//        String[] arr = a.split(":");
//
//        String b = "a b c  d";
//        String[] arr2 = b.split((" "));
//        String[] arr3 = b.split(("\\s+"));
//        System.out.println(arr2.length);
//        System.out.println(arr3.length);

////        null과 공백의 차이
//        String st1=null;//null은 문자열 아님
//        String st2=""; //빈문자열은 문자열
//        String st3=" ";
//        System.out.println(st1==st2);//false
////        System.out.println(st1.isEmpty());//nullpointer exception발생
//        System.out.println(st2.isEmpty());//true
//        System.out.println(st3.isEmpty());//false
//        System.out.println(st3.isBlank());//true//실전
//
////        공백의 개수 세기
//        String abc = "hello    world    java";
//        int total=0;
//        for(int i=0;i<abc.length();i++){
//            if(abc.substring(i,i+1).isBlank()){
//                total++;
//            }
//        }
//        System.out.println(total);

////        문자열 조립 : StringBuffer, StringBuilder(중요)
//        String[] arr = {"java", "python", "javascript"};
//        StringBuffer sb = new StringBuffer();
//        String result = "";
//        for(int i=0;i<arr.length;i++){
//            sb.append(arr[i]);
//            sb.append("\n");//\n은 줄바꿈을 의미
//        }
//        sb.insert(0, "C++");//문자열 중간에 insert하는 것은 성능저하를 발생 쓰면안됨
//        sb.deleteCharAt(sb.length()-1);//마지막 index를 삭제하는 것 외에는 성능저하 발생
//        result = sb.toString();
//        System.out.println(result);

//        StringBuilder는 성능이 뛰어나지만, 동시성문제(값이 틀어지는것)(Thread-Safe하지 않음)있음 //실전에선 SB안씀 혹시쓰면 StringBuffer씀
//        예를 들어)쓰레드A가 append("hello") 쓰레드B가 append("world")
//        이 두작업이 중간에 섞여 "heworlllo" 이런식으로 잘못된 값을 만들수 있음
//        StringBuilder sb2 = new StringBuilder();

////        문자열뒤집기(써도됨)
//        String st1 = "hello";
//        StringBuilder sb2 = new StringBuilder();
//        for (int i=st1.length()-1;i>=0;i--){
//            sb2.append(st1.charAt(i));
//        }
//        System.out.println(sb2);
//        StringBuilder sb = new StringBuilder(st1);
//        System.out.println(sb.reverse());

//        프로그래머스 - 문자열밀기 틀림
//        문자열비교
        String st1 = "hello";
        String st2 = "dello";
        String st3 = "hfllo";
        String st4 = "hello";
        String st5 = "h";

        System.out.println(st1.compareTo(st2)); //양수 h-d 아스키코드 값
        System.out.println(st2.compareTo(st1)); //음수
        System.out.println(st1.compareTo(st4)); //0
        System.out.println(st1.compareTo(st3)); //e-f 두번째 값으로 비교

        System.out.println(st4.compareTo(st5));
    }
}
