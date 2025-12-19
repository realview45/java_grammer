package C05AnonymousLambda;
//내부클래스 : 클래스 안에 클래스
//1)static내부클래스 2)익명내부클래스
public class C01InnerClass {
    public static void main(String[] args) {
//        static내부클래스를 활용한 객체 생성
        Member.MemberInner mi = new Member.MemberInner(20);
        System.out.println(mi.getB());
    }
}
class Member{
    private int a;
    public Member(int a) {
        this.a = a;
    }
    public int getA(){
        return this.a;
    }
//    static내부클래스 : Member의 static변수처럼 활용
    static class MemberInner{//Member클래스의 static내부클래스 Member.MemberInner
        private int b;
        public MemberInner(int b) {
            this.b = b;
        }
        public int getB(){
            return b;
        }
    }
}