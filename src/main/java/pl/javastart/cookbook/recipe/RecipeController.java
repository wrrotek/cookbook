package pl.javastart.cookbook.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.cookbook.category.Category;
import pl.javastart.cookbook.category.CategoryRepository;

import java.util.List;

@Controller
public class RecipeController {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    public RecipeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/recipes")
    public String auctions(Model model,
                           @RequestParam(required = false) String sort,
                           Category categoryFilters) {
        List<Recipe> categories;
        if (sort != null) {
            categories = recipeRepository.findByCategory(categoryFilters);
        } else {
            categories = recipeRepository.findAll(sort);
        }

        model.addAttribute("cars", categories);
        model.addAttribute("filters", categoryFilters);
        return "auctions";
    }

    @GetMapping("/recipe/add")
    public String addForm(Model model, @RequestParam Long catId) {
        Recipe recipe = new Recipe();
        recipe.setCategory(categoryRepository.findById(catId).orElse(null));
        model.addAttribute("recipe", recipe);
        model.addAttribute("category", categoryRepository.findAll());
        return "budynekDodaj";
    }

    @PostMapping("/recipe/add")
    public String addForm(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/category/" + recipe.getCategory().getId();
    }


    @GetMapping("/recipe/delete/{id}")
    public String delete(@PathVariable Long id) {
        recipeRepository.deleteRecipeById(id);
        return "redirect:/";
    }
}
