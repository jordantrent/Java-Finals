import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    private ArrayList<Recipe> recipes;
    private ArrayList<String> ingredients;
    private String name;
    private int cookingTime;

    public Recipe(String name, int cookingTime, ArrayList<String> ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;

    }

    public static ArrayList<Recipe> recipeFind(ArrayList<Recipe> recipes, String search) {
        ArrayList<Recipe> foundRecipe = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.name.contains(search)) {
                foundRecipe.add(recipe);
            }
        }
        return foundRecipe;
    }

    public static ArrayList<Recipe> recipeTime(ArrayList<Recipe> recipes, int search) {
        ArrayList<Recipe> foundRecipe = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.cookingTime <= search) {
                foundRecipe.add(recipe);
            }
        }
        return foundRecipe;
    }

    public static ArrayList<Recipe> recipeIngredient(ArrayList<Recipe> recipes, String search) {
        ArrayList<Recipe> foundRecipe = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.ingredients.contains(search)) {
                foundRecipe.add(recipe);
            }
        }
        return foundRecipe;
    }

    public static ArrayList<Recipe> readRecipes(String file) {
        ArrayList<Recipe> recipes;
        ArrayList<String> ingredients;
        String name = null;
        int cookingTime = 0;
        recipes = new ArrayList<>();
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            ingredients = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String row = myReader.nextLine();
                if (row.isEmpty()) {
                    recipes.add(new Recipe(name, cookingTime, ingredients));
                    name = null;
                    cookingTime = 0;
                    ingredients = new ArrayList<>();
                } else {
                    if (name == null) {
                        name = row;
                    } else if (cookingTime == 0) {
                        cookingTime = Integer.valueOf(row);
                    } else {
                        ingredients.add(row);
                    }
                }
            }
            if (name != null) {
                recipes.add(new Recipe(name, cookingTime, ingredients));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return recipes;

    }

    public static void printAll(ArrayList<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    @Override
    public String toString() {
        return name + ", cooking time: " + cookingTime;
    }

}