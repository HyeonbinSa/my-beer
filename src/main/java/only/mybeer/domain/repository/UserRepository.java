package only.mybeer.domain.repository;

import only.mybeer.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 회원 정보 임시 저장
 */

@Repository
public class UserRepository {
    private static final Map<String, User> userMap = new HashMap<>();
    private static long sequence = 0L;

    // 1. 회원 가입
    public User join(User user) {
        user.setNo(++sequence);
        userMap.put(user.getId(), user);
        return user;
    }

    // 2. 회원 목록 조회
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    // 3. 회원 조회
    public User getUserById(String id) {
        return userMap.get(id);
    }

    // 4. 회원 정보 수정
    public void updateUser(User user) {
        User updatedUser = userMap.get(user.getId());
        updatedUser.setPw(user.getPw());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setName(user.getName());
    }

    // 5. 회원 삭제
    public void deleteUser(String id) {
        userMap.remove(id);
    }
}
