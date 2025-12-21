package C03Inheritance.C03Inheritance.ProtectedPackage;
import C03Inheritance.C04ProtectedClass;

public class C05ProtectedTest extends C04ProtectedClass {
    public static void main(String[] args) {
        C05ProtectedTest c1 = new C05ProtectedTest();
        System.out.println(c1.st1);//public
        //System.out.println(c1.st2);//private
        //System.out.println(c1.st3);//default
        System.out.println(c1.st4);//protect
    }
}
