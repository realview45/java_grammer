package C07ExceptionFileParsing.MemberException;
//객체 - 엔티티
public class Member {
    private static Long staticId = 0L;
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        staticId++;
        id = staticId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
