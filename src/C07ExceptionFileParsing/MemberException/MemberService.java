package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//핵심로직을 구현하는 계층
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService() {
        memberRepository = new MemberRepository();
    }
    public Member register(String name, String email, String password) throws IllegalArgumentException{
//        List(DB)에 이메일이 중복일경우 (IllegalArguments)예외 발생
        Optional<Member> optMember = memberRepository.findByEmail(email);
        if (optMember.isPresent()) {
            throw new IllegalArgumentException("이메일 중복입니다.");
        }
//        객체 조립 후 repository를 통해 저장
        Member newMember = new Member(name, email, password);
        memberRepository.register(newMember);
        return newMember;
    }
    public Member findById(long id) throws NoSuchElementException{// throws 장식
        Member member = memberRepository.findById(id).orElseThrow(()->new NoSuchElementException("없는 사용자입니다."));
        return member;
    }
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public void login(String email, String password) throws NoSuchElementException, IllegalArgumentException{
        //        email이 있는지 확인 후 없으면 예외발생
        Member member = memberRepository.findByEmail(email).orElseThrow(()-> new NoSuchElementException("Email과 일치하는 회원이 없습니다."));
//        password가 일치한지 확인 후 일치하지 않으면 예외 발생
        if (!member.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호 일치X");//unchecked
        }
    }
}
