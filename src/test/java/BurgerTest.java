import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Database database = new Database();
    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();
    Burger burger = new Burger();
    private Ingredient ingredient;
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Ingredient actualIngredient = ingredient;
        Ingredient expectedIngredient = burger.ingredients.get(burger.ingredients.size()-1);
        assertEquals(expectedIngredient,actualIngredient);
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        int sizeIngredient = burger.ingredients.size();
        int removeIndex = (int) (Math.random() * (sizeIngredient-1));
        int actualSize = sizeIngredient;
        burger.removeIngredient(removeIndex);
        int expectedSize = burger.ingredients.size();
        assertEquals(expectedSize,actualSize-1);
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        int sizeIngredient = burger.ingredients.size();
        int newIndex = (int) (Math.random() * (sizeIngredient-1));
        int index = (int) (Math.random() * (sizeIngredient-1));
        Ingredient expectedIngredient = burger.ingredients.get(index);
        burger.moveIngredient(index,newIndex);
        Ingredient actualIngredient = burger.ingredients.get(newIndex);
        assertEquals(expectedIngredient, actualIngredient);
    }
    @Test
    public void getPriceTest() {
        buns.add(new Bun("black bun", 100));
        ingredients.add(new Ingredient(SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(FILLING, "sausage", 300));

        Mockito.when(database.availableBuns()).thenReturn(buns);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);

        List<Bun>buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(2));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(4));

        float expectedPrice = burger.getPrice();
        float actualPrice = buns.get(0).getPrice() * 2
                + ingredients.get(1).getPrice()
                + ingredients.get(2).getPrice()
                + ingredients.get(3).getPrice()
                + ingredients.get(4).getPrice();
        assertEquals(expectedPrice,actualPrice,0);
    }
}