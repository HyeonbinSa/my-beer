package only.mybeer.domain.repository;

import only.mybeer.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {
    CategoryRepository categoryRepository = new CategoryRepository();

    @AfterEach
    void afterEach() {
        categoryRepository.clear();
    }

    @Test
    void saveTest() {
        Category category1 = new Category("흑맥주");
        Category category2 = new Category("IPA");
        Category category3 = new Category("라거");

        Category savedCategory = categoryRepository.save(category1);
        Assertions.assertThat(savedCategory).isEqualTo(category1);

        savedCategory = categoryRepository.save(category2);
        Assertions.assertThat(savedCategory).isEqualTo(category2);

        savedCategory = categoryRepository.save(category3);
        Assertions.assertThat(savedCategory).isEqualTo(category3);

        Assertions.assertThat(savedCategory.getCategoryId()).isEqualTo(3);
    }

    @Test
    void findAll() {
        Category category1 = new Category("흑맥주");
        Category category2 = new Category("IPA");
        Category category3 = new Category("라거");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        Assertions.assertThat(categoryRepository.getCategories().size()).isEqualTo(3);
    }

    @Test
    void updateTest() {
        Category category1 = new Category("흑맥주");
        Category category2 = new Category("IPA");
        Category category3 = new Category("라거");

        categoryRepository.save(category1);
        Category savedCategory = categoryRepository.save(category2);
        categoryRepository.save(category3);

        Long categoryId = savedCategory.getCategoryId();

        Category updateCategory = new Category("위트에일");

        categoryRepository.update(categoryId, updateCategory);

        Assertions.assertThat(categoryRepository.getCategoryById(categoryId).getCategoryName()).isEqualTo("위트에일");
    }

    @Test
    void removeTest() {
        Category category1 = new Category("흑맥주");
        Category category2 = new Category("IPA");
        Category category3 = new Category("라거");
        categoryRepository.save(category1);
        Category savedCategory = categoryRepository.save(category2);
        categoryRepository.save(category3);

        categoryRepository.remove(savedCategory.getCategoryId());

        Assertions.assertThat(categoryRepository.getCategories().size()).isEqualTo(2);
    }
}