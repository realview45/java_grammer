package C02MethodClass;
import java.util.*;
/*
        <게시판서비스>
        1.계좌객체 : Author, Post
        2.자료구조 : List(authorList, postList)
        3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
            3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
            3-2.회원 전체 목록 조회 : id, email
            3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수//(postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
            3-4.게시글 작성 : id, title, contents, 작성자Email//(직접 Author 객체를 변수로 갖는것도 가능)
            3-5.게시물 목록 조회 : id(post), title
            3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름

*/
public class C10BoardService {
    public static void main(String[] args) {
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        Set<String> emailSet = new HashSet<>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("원하시는 서비스 번호를 입력해주세요.\n" +
                    "1)회원가입\t\t" +
                    "2)목록조회\t\t" +
                    "3)상세조회\n" +
                    "4)게시글 작성\t\t" +
                    "5)게시글 목록조회\t" +
                    "6)게시글 상세조회");
            int number = Integer.parseInt(sc.nextLine());
            if (number == 1) {
                System.out.println("회원가입서비스입니다.");
                System.out.print("이름 : ");
                String name = sc.nextLine();
                System.out.print("이메일 : ");
                String email = sc.nextLine();
                while(emailSet.contains(email)){
                    System.out.println("이메일이 중복됩니다. 다시 입력해주세요.");
                    email = sc.nextLine();
                }
                emailSet.add(email);
                System.out.print("비밀번호 : ");
                String password = sc.nextLine();
                Author a = new Author(name,email,password);
                authorList.add(a);
                System.out.println("회원가입완료");
                System.out.println("이름: "+a.getName() + "이메일: " + a.getEmail()+ "패스워드: " + a.getPassword());
            } else if (number == 2) {
                System.out.println("목록조회서비스입니다.");
                if(authorList.isEmpty()){
                    System.out.println("사용자목록이 비었습니다.");
                }
                for (Author a : authorList) {
                    System.out.println("id: " + a.getId() + " email: " + a.getEmail() + " postCnt: " + a.getPostList().size());
                }
            } else if (number == 3) {
                System.out.println("상세조회서비스입니다.");
                System.out.println("조회할 AuthorID를 입력하세요");
                Long authorId = Long.parseLong(sc.nextLine());
                boolean find = false;
                for(Author a : authorList){
                    if(a.getId().equals(authorId)){
                        System.out.println("id: " + a.getId() + " email: " + a.getEmail()+
                                " name: " + a.getName() + " password: " + a.getPassword() +  " postCnt: " + a.getPostList().size());
                        find = true;
                        break;
                    }
                }
                if(!find) {
                    System.out.println("Author가 존재하지 않습니다.");
                }
            } else if (number == 4) {
                System.out.println("게시글을 작성합니다.");
                System.out.print("Title : ");
                String title = sc.nextLine();
                System.out.print("Contents : ");
                String contents = sc.nextLine();
                System.out.print("이메일 : ");
                String email = sc.nextLine();
                if (!emailSet.contains(email)){
                    System.out.println("이메일이 유효하지 않습니다.");
                    continue;
                }
                Author author = null;
                for(Author a : authorList){
                    if(a.getEmail().equals(email)){
                        author = a;
                    }
                }
                Post p = new Post(title,contents,author);
                postList.add(p);
                System.out.println("게시글이 작성되었습니다.");
                System.out.println("Title: "+ p.getTitle() + "Contents: " + p.getContents());
            } else if (number == 5) {
                System.out.println("게시글 목록조회서비스입니다.");
                if(postList.isEmpty()){
                    System.out.println("게시글 목록이 비었습니다.");
                }
                for (Post p : postList) {
                    System.out.println("id: " + p.getId());
                }
            } else if (number == 6) {
                System.out.println("게시글 상세조회서비스입니다.");
                System.out.println("조회할 PostID를 입력하세요");
                Long postId = Long.parseLong(sc.nextLine());
                boolean find = false;
                for(Post p : postList){
                    if(p.getId().equals(postId)){
                        Author author = p.getAuthor();
                        System.out.println("id: " + p.getId() + " title: " +
                                p.getTitle() + " contents: " +p.getContents() + "author : " + author.getName());
                        find = true;
                        break;
                    }
                }
                if(!find){
                    System.out.println("게시글이 존재하지 않습니다.");
                }
            }
        }
    }
}
class Author {
    private static Long staticId = (long)0;
    private Long id;
    private String email;
    private String name;
    private String password;

    private List<Post> postList = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public Author(String name, String email, String password) {
        staticId++;
        this.id = staticId;
        this.email = email;
        this.name = name;
        this.password = password;

    }
}
class Post {
    private static Long staticId = (long)0;
    private Long id;
    private String title;
    private String contents;

    //
    private Author author;
    //private String email;
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContents() {
        return contents;
    }
    public Author getAuthor(){
        return author;
    }
    public Post(String title, String contents, Author author) {
        staticId++;
        this.id = staticId;
        this.title = title;
        this.contents = contents;
        this.author = author;
        author.getPostList().add(this);
    }
}