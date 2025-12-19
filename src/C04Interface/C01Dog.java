package C04Interface;

public class C01Dog implements C01AnimalInterface1{

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}