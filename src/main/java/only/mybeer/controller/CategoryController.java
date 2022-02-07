package only.mybeer.controller;

import lombok.RequiredArgsConstructor;
import only.mybeer.domain.Category;
import only.mybeer.domain.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/product/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;
    /**
     * Test Data 추가
     */
    @PostConstruct
    public void init() {
        categoryRepository.save(new Category("흑맥주"));
        categoryRepository.save(new Category("라거"));
        categoryRepository.save(new Category("IPA"));
    }
}
