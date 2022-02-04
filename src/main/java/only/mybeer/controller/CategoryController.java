package only.mybeer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/product/category")
public class CategoryController {

    /**
     * Test Data 추가
     */
    @PostConstruct
    public void init() {

    }
}
