import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunNameParamTest {
    private final String name;
    private final float price = 50;

    public BunNameParamTest(String name) {
        this.name = name;
    }
    @Parameterized.Parameters
    public static Object[][] getTypeAndNameAndPriceIngredient() {
        return new Object[][]{
                {"Марсовое барбекю"},
                {""},
                {"It's name is very very very very very very very looooooong"},
                {1 + "\"{name,..}"},
                {null}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name,price);
        String actualName = bun.getName();
        String expectedName = name;
        assertEquals(expectedName,actualName);
    }
}
