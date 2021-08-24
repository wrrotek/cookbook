package pl.javastart.cookbook.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import pl.javastart.cookbook.category.Category;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByCategory(Category category);

    List<Recipe> findAll(String sort);

    @Modifying
    @Transactional
    void deleteRecipeById(Long id);
}
