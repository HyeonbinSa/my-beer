package only.mybeer.controller;

import lombok.RequiredArgsConstructor;
import only.mybeer.domain.User;
import only.mybeer.domain.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.join(new User("hello", "test1234", "실험맨", "hello@gmail.net"));
        userRepository.join(new User("Test12", "test1234", "테스트", "test@gmail.net"));
        userRepository.join(new User("sabin", "1234", "빈싸", "sabin@gmail.net"));
    }
}
