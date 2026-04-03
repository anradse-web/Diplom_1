package praktikum;
<<<<<<< HEAD
=======

>>>>>>> c78a3989c062176e357acce8e036a61c079b96e9
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
<<<<<<< HEAD

    private Burger burger;

=======
    private Burger burger;
>>>>>>> c78a3989c062176e357acce8e036a61c079b96e9
    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    private final float bunPrice;
    private final float ingredientPrice;
    private final float expectedPrice;

    public BurgerParameterizedTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;

    }
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }
    @Parameterized.Parameters(name = "Цена бургера: булка={0}, ингредиент={1}")
    public static Collection<Object[]> data() {
<<<<<<< HEAD
        return Arrays.asList(new Object[][] {
=======
        return Arrays.asList(new Object[][]{
>>>>>>> c78a3989c062176e357acce8e036a61c079b96e9
                // нормальные случаи
                {300f, 100f, 700f},
                {100f, 200f, 400f},
                {200f, 0f, 400f},
<<<<<<< HEAD

                // граничный случай, нулевые цены
                {0f, 0f, 0f},

                // крайний случай, очень дорогой ингридиент
                {100f, 1000f, 1200f}
        });

}  @Test
=======
                // граничный случай, нулевые цены
                {0f, 0f, 0f},
                // крайний случай, очень дорогой ингридиент
                {100f, 1000f, 1200f},

        });
    }  @Test
>>>>>>> c78a3989c062176e357acce8e036a61c079b96e9
    public void checkBurgerPriceCalculation() {
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }
}

