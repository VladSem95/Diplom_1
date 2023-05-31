import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class ParamIngredientAndIngredientTypeTest {
    private final IngredientType type;
    private final String name;
    private final float price ;
    public ParamIngredientAndIngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getTypeAndNameAndPriceIngredient() {
        return new Object[][]{
                {SAUCE, "Марсовое барбекю", 50},
                {FILLING, "Мраморная Луна", 100}
        };
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredientType = ingredient.getType();
        IngredientType expectedIngredientType = type;
        assertEquals(expectedIngredientType,actualIngredientType);
    }
    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualIngredientName = ingredient.getName();
        String expectedIngredientName = name;
        assertEquals(expectedIngredientName,actualIngredientName);
    }
    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualIngredientPrice = ingredient.getPrice();
        float expectedIngredientPrice = price;
        assertEquals(expectedIngredientPrice,actualIngredientPrice,0);
    }
}
