package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(filling);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(filling, burger.ingredients.get(0));
    }

    @Test
    public void getPriceIngredientsTest() {
        Mockito.when(bun.getPrice()).thenReturn(300f);
        Mockito.when(filling.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(filling);
        Assert.assertEquals(700f, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceiptContainsBunName() {
        Mockito.when(bun.getName()).thenReturn("Краторная булка");
        burger.setBuns(bun);
        Assert.assertTrue(burger.getReceipt().contains("Краторная булка"));
    }

    @Test
    public void getReceiptContainsIngredientName() {
        Mockito.when(bun.getName()).thenReturn("Краторная булка");
        Mockito.when(filling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(filling.getName()).thenReturn("Биокотлета из марсианской Магнолии");

        burger.setBuns(bun);
        burger.addIngredient(filling);

        String receipt = burger.getReceipt();

        Assert.assertTrue(receipt.contains("Краторная булка"));
        Assert.assertTrue(receipt.contains("Биокотлета из марсианской Магнолии"));
        Assert.assertTrue(burger.getReceipt().contains("Биокотлета из марсианской Магнолии"));
    }

    @Test
    public void getReceiptContainsCorrectPrice() {
        Mockito.when(bun.getName()).thenReturn("Краторная булка");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        burger.setBuns(bun);

        Assert.assertTrue(burger.getReceipt().contains("Price: 600,000000"));
    }
}