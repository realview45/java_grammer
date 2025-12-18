package C02MethodClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class C07Constructor {
    public static void main(String[] args) {
//        캘린더 객체 생성
        Calendar myCalendar = new Calendar("10월","10일");

////        캘린더 객체 출력
//        myCalendar.setDay("15일");
//        myCalendar.setMonth("1월");
//        myCalendar.setYear("2025년");

//        캘린더 객체 출력
        System.out.println(myCalendar);

//      java자료구조내에 직접 만든 객체를 담아 관리
        //꺾쇠 안에 클래스이기만 하면 어떤갓이든 받음 제네릭구조
        List<Calendar> myList = new ArrayList<>();
        myList.add(myCalendar);
        myList.add(new Calendar("2024", "01", "12"));
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));

    }
}
class Calendar {
    private String year = "2024"; //변수의 안정성을 높이기 위해
    private String month = "1";
    private String day = "25";
    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

//    생성자 : 객체가 만들어지는(new) 시점에 호출되는 메서드
//    생성자특징 : 1)클래스명과 메서드명이 동일 2)반환타입이 없음
//    생성자의 사용목적 : 객체 생성시점에 객체변수값들을 초기화(세팅) 변수의 안정성을 위해 setter 사용을 지양하고, 생성자를 사용
//    직접 생성자를 1개라도 추가할 경우, 초기(기본)생성자는 무시가 되므로, 필요시 별도로 추가
    public Calendar (String year, String month, String day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Calendar(String day, String month) {
        this("2026년",month,day);
    }

    public Calendar (){
    }

    //    toString()메서드는 객체명으로 출력시 자동으로 메서드가 호출
    @Override
    public String toString() {
        return "{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
//클래스명 : Calendar, 변수 : year, month, day 모두 String
