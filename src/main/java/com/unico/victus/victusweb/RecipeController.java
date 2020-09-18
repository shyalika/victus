package com.unico.victus.victusweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.unico.victus.victusweb.db.RecipeBase;
import com.unico.victus.victusweb.entity.RecipeObject;
import com.unico.victus.victusweb.entity.RecipeView;

@Controller
public class RecipeController {

    @Autowired
    private RecipeBase recipeBase;

    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable("id") String id, Model model)
            throws JsonSyntaxException, JsonIOException, JsonParseException, JsonMappingException,
            IOException {

        try {
            RecipeObject recipe = recipeBase.findRecipe(id);
            recipe.getPage().getRecipe().setSteps(getRandomSteps());
            model.addAttribute("view", new RecipeView(recipe.getPage(), getRandomImage()));
            return "recipe";
        } catch (Exception e) {
            return "recipe-not-found";
        }

    }

    /**
     * @return
     */
    private String getRandomImage() {

        return "../images/thumbs/0" + ThreadLocalRandom.current().nextInt(1, 4 + 1) + ".jpg";

    }

    private List<String> getRandomSteps() {
        List<String> steps = new ArrayList<String>();
        steps.add(
                "Preheat oven to a 210C. Lightly grease or line a tray of 12 cup with muffin paper cases.");
        steps.add(
                "Sift flour and sugar into a bowl. Add combined egg, milk, topping and butter and stir gently until mixed.");
        steps.add(
                "Half fill each paper case with mixture. Add a teaspoon of Top'n Fill caramel to each, then top with remaining batter.");
        steps.add("Bake for 18-20 minutes or until firm.");
        steps.add("Cool pans for 2 minutes, then turn onto wire rack to cool.");
        steps.add(
                "Beat cream cheese until smooth and beat in remaining caramel. Spread over muffins, top with chocolate drops and icing sugar.");
        return steps;
    }

    @GetMapping("/recipes/{id}")
    public String showRecipeList(@PathVariable("ids") String ids) {

        return "index";

    }

}
