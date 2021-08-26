package pl.javastart.cookbook.recipe;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    private List<Recipe> recipes;

    public List<Recipe> findAllForFilters(RecipeFilters recipeFilters) {
        return recipeRepository.findByNameContainsIgnoreCase(recipeFilters.getName());
    }
}
