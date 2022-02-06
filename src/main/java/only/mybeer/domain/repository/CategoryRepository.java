package only.mybeer.domain.repository;

import only.mybeer.domain.Category;
import only.mybeer.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CategoryRepository {
    private static final Map<Long, Category> categoryMap = new HashMap<>();
    private static long sequence = 0L;

    // 1. Category 등록
    public Category save(Category category) {
        category.setCategoryId(++sequence);
        categoryMap.put(category.getCategoryId(), category);
        return category;
    }

    // 2. Category 목록 조회
    public List<Category> getCategories() {
        return new ArrayList<>(categoryMap.values());
    }

    // 3. Category id로 조회
    public Category getCategoryById(Long categoryId) {
        return categoryMap.get(categoryId);
    }

    // 4. Category 삭제
    public Category remove(Long categoryId) {
        return categoryMap.remove(categoryId);
    }

    // 5. Category 수정
    public void update(Long categoryId, Category updateCategory) {
        Category category = categoryMap.get(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
    }

    // 6. Category 전체 삭제
    public void clear() {
        categoryMap.clear();
    }
}
