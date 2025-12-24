package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C02Calendar {//실전에서꽤씀
    public static void main(String[] args) {
////        java.util패키지의 Calendar클래스 //잘 안씀
//        Calendar myCalendar = Calendar.getInstance();
//        System.out.println(myCalendar.getTime());
//        System.out.println(myCalendar.get(Calendar.YEAR));//enum타입(static변수)가 사용되고 있다
//        System.out.println(myCalendar.get(Calendar.MONTH)+1);
//        System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK));//요일
//        System.out.println(myCalendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(myCalendar.get(Calendar.HOUR));
//        System.out.println(myCalendar.get(Calendar.MINUTE));
//        System.out.println(myCalendar.get(Calendar.SECOND));


//        java.time패키지의 LocalDateTime(웹개발 중요), LocalDate, LocalTime 클래스
        LocalDate myLocalDate = LocalDate.now();
        System.out.println(myLocalDate);//2025-12-23
        System.out.println(myLocalDate.getYear());//2025
        System.out.println(myLocalDate.getMonth());//DECEMBER
        System.out.println(myLocalDate.getMonthValue());//12
        System.out.println(myLocalDate.getDayOfMonth());//23
        System.out.println(myLocalDate.getDayOfWeek());//TUESDAY

        LocalTime myLocalTime = LocalTime.now();
        System.out.println(myLocalTime.getHour());//9
        System.out.println(myLocalTime.getMinute());//48
        System.out.println(myLocalTime.getSecond());//47

        LocalDateTime myLocalDateTime = LocalDateTime.now();
        System.out.println(myLocalDateTime.getYear());
        System.out.println(myLocalDateTime.getHour());
//        ChronoField매개변수로 다양한 형식의 날짜/시간정보 조회
        System.out.println(myLocalDateTime.get(ChronoField.YEAR));
        System.out.println(myLocalDateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(myLocalDateTime.get(ChronoField.AMPM_OF_DAY));//0:오전, 1:오후
        System.out.println(myLocalDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY));//24시체계

//        .of: 임의로 특정시간정보객체를 만들어내고 싶을 때 사용
        LocalDate birthDay = LocalDate.of(2000,11,12);
        System.out.println(birthDay);//2000-11-12

        LocalDateTime birthDayTime = LocalDateTime.of(2000,11,12,15,14,10);
        System.out.println(birthDayTime);//2000-11-12T15:14:10
    }
}
