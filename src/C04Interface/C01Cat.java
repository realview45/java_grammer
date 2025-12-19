package C04Interface;
//인터페이스 구현(상속)시 implements 키워드 사용
//인터페이스의 다중상속은 허용
public class C01Cat implements C01AnimalInterface1,C01AnimalInterface2{

    @Override
    public void makeSound() {
        System.out.println("냐옹냐옹");
    }

    @Override
    public void eat(String food) {
        System.out.println(food + "를 먹습니다.");
    }
}
