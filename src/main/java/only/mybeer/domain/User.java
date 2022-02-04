package only.mybeer.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원 정보
 */

@Getter
@Setter
public class User {
    private Long no;
    private String id;
    private String pw;
    private String name;
    private String email;

    public User() {

    }

    public User(String id, String pw, String name, String email) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }
}
