package C03Inheritance;

//부모클래스를 상속받을 때, 자식객체의 생성자에서는 부모객체를 자동으로 생성
//이때, 부모클래스에 기본생성자가 없으면 자식클래스에서 에러발생(매개변수 값을 모르기때문에?)
public class C02SuperKeyword extends SuperParents{//스프링에서는 main메서드를 거의 사용X
    public C02SuperKeyword(){
//        super() : 부모클래스의 생성자를 호출하는 메서드
        super(10);
        this.a =20;
    }
    public static void main(String[] args) {
        C02SuperKeyword c1 =new C02SuperKeyword();
        System.out.println(c1.a);
        c1.display();
    }
    public void display(){
        System.out.println("자식의 변수 : " + this.a);
//        부모의 변수나 메서드에 접근할 때에는 super키워드를 사용(거의 안씀)
        System.out.println("부모의 변수 : " + super.a);
    }
}
class SuperParents{
    int a=10;
    public SuperParents(int a){
        this.a = a;
    }
}