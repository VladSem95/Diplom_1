import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


public class BunTest {
    private final String name = "Лунный хлеб";
    private final float price = 500;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name,price);
        String actualName = bun.getName();
        String expectedName = name;
        assertEquals(expectedName,actualName);
    }
    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name,price);
        float actualPrice = bun.getPrice();
        float expectedPrice = price;
        assertEquals(expectedPrice,actualPrice,0);
    }
}
