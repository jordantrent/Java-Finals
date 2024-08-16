
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File to read: ");
        String file = scanner.nextLine();
        ArrayList<Recipe> recipes = Recipe.readRecipes(file);

        while (true) {
            System.out.println("Enter Command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println(recipes.toString());
            }
            if (command.equals("find name")) {
                System.out.println("Searched word");
                String word = scanner.nextLine();
                ArrayList<Recipe> recipe = Recipe.recipeFind(recipes, word);
                System.out.println(recipe);
            }
            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                int maxCook = Integer.valueOf(scanner.nextLine());
                ArrayList<Recipe> recipe = Recipe.recipeTime(recipes, maxCook);
                System.out.println(recipe);
            }
            if (command.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String ingredient = scanner.nextLine();
                ArrayList<Recipe> recipe = Recipe.recipeIngredient(recipes, ingredient);
                System.out.println(recipe);
            }

        }

    }
}