package only.mybeer.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원 정보
 */

@Getter
@Setter
public class User {
    private Long userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String email;

    public User() {

    }

    public User(String userId, String userPw, String userName, String email) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.email = email;
    }
}
