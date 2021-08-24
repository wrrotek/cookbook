package pl.javastart.cookbook.category;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category/{name}")
    public String category(@PathVariable String name, Model model) {
        Optional<Category> categoryOptional = categoryRepository.findByName(name);

        if (categoryOptional.isPresent()) {
            Category cat = categoryOptional.get();
            model.addAttribute("category", cat);
            return "category";
        } else {
            return "error";
        }
    }

}
