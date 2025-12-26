package C10Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Validation {
    public static void main(String[] args) throws IllegalAccessException {
        List<Member> memberList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("회원가입 서비스입니다.");
            System.out.println("이름을 입력해주세요.");
            String name = sc.nextLine();
            System.out.println("이메일을 입력해주세요.");
            String email = sc.nextLine();

            Member member = new Member(name,email);
//            추후 스프링에서는 아래와 같은 "validate메서드 + 직접만든어노테이션"이 모두 합해져있는 이미 만들어진 어노테이션을 사용.
            validate(member);
            memberList.add(member);
        }
    }
//    특정 변수에 NotEmpty 어노테이션 설정이 있을경우, 값이 비어있는지를 검사하는 메서드.
    static void validate(Object object) throws IllegalAccessException {//런타임시점에 어노테이션이있는지 리플렉션기술이 검사구리
//        리플렉션 기술을 통해 런타임시점에 private변수라 할지라도 객체 안의 필드값을 꺼내 확인할 수 있음.
        Field[] fieldList = object.getClass().getDeclaredFields();//선언된 필드를 가져와서
        for(Field f :fieldList){
            if(f.isAnnotationPresent(NotEmpty.class)){//필드에 어노테이션이 붙었다면
                f.setAccessible(true);
                String value = (String)f.get(object);//가져와서
                if(value==null||value.isEmpty()){
                    NotEmpty n1 = f.getAnnotation(NotEmpty.class);
                    throw new IllegalArgumentException(n1.message());//에러를 던진다.
                }
            }
        }
    }
}
class Member{
    private String name;
    @NotEmpty//골뱅이 붙는건 다 인터페이스클래스 not null 기능(클래스)만들어보기  //변수 또는 클래스상단에 붙을수 있음구리
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

//어노테이션은 선언적 표시이고, 어떤 기능도 수행하지 않음.
//아래 NotEmpty어노테이션 클래스는 어떤 기능도 없지만, 특정 필드값이 비어있으면 안된다는 선언적 표시.
//리플렉션은 기본적으로 런타임에 동작하므로, 어노테이션을 사용할때에 기본적으로 런타임 동작 설정. ((사용자가 입력할때 입력안할때))
@Retention(RetentionPolicy.RUNTIME)
@interface NotEmpty{
//    어노테이션 클래스의 속성은 일반적으로 메서드 형태로 정의
    String message() default  "this field cannot be empty!!";
}
//스프링에서는 통합형 어노테이션(NotEmpty메소드까지다있는)을 사용하고,(이미만든거) 리플렉션을 근간하여 만들어진다.(private변수 접근)구리