package com.unico.victus.victusweb.db;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unico.victus.victusweb.RecipeController;
import com.unico.victus.victusweb.entity.RecipeObject;

@Component
@Scope("singleton")
public class RecipeBase {

    private List<RecipeObject> recipes;

    @PostConstruct
    public void loadData() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RecipeObject[] recipesArray = objectMapper.readValue(
                new InputStreamReader(
                        RecipeController.class.getClassLoader().getResourceAsStream("merged.json")),
                RecipeObject[].class);

        recipes = Arrays.asList(recipesArray);
    }

    public RecipeObject findRecipe(String id) {

        return recipes.stream().filter(
                ro -> ro.getPage().getArticle().getId().equals(id)).findFirst().get();

    }
}
