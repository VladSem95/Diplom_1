import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceParamTest {
    private final String name = "Лунный хлеб";
    private final float price;

    public BunPriceParamTest(float price) {
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getTypeAndNameAndPriceIngredient() {
        return new Object[][]{
                {500},
                {-1},
                {0},
                {100.2F}
        };
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name,price);
        float actualPrice = bun.getPrice();
        float expectedPrice = price;
        assertEquals(expectedPrice,actualPrice,0);
    }
}
