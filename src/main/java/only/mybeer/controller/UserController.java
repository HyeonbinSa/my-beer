package only.mybeer.controller;

import lombok.RequiredArgsConstructor;
import only.mybeer.domain.User;
import only.mybeer.domain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "";
    }

    // 회원 등록 Form 이동
    @GetMapping("/join")
    public String joinForm() {
        return "user/joinUser";
    }

    // 회원 등록 기능
    @PostMapping("/join")
    public String joinUser(@ModelAttribute User user, Model model) {
        userRepository.join(user);
        model.addAttribute("user", user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String users(Model model) {
        List<User> users = userRepository.getUsers();
        model.addAttribute("users", users);
        return "user/userList";
    }

    @GetMapping("/{id}")
    public  String user(@PathVariable String userId, Model model){
        User user = userRepository.getUserById(userId);
        model.addAttribute("model", model);
        return "users/";    }
    @PostConstruct
    public void init() {
        userRepository.join(new User("hello", "test1234", "실험맨", "hello@gmail.net"));
        userRepository.join(new User("Test12", "test1234", "테스트", "test@gmail.net"));
        userRepository.join(new User("sabin", "1234", "빈싸", "sabin@gmail.net"));
    }
}
