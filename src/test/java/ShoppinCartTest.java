import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppinCartTest {

    ShoppinCart cart = new ShoppinCart();

    @Test
    void calculateTotalTest(){
        cart.addItemToCart(new Item(5.0));
        cart.addItemToCart(new Item(3.5));
        assertEquals(8.5, cart.calculateTotal());
    }

    @Test
    void verifyItemPrices(){
        Item item1 = new Item(5.57);
        Item item2 = new Item(8.26);
        Item item3 = new Item(12.53);
        Item item4 = new Item(193.2);

        assertAll(
                () -> assertEquals(5.57, item1.getPrice()),
                () -> assertEquals(8.26, item2.getPrice()),
                () -> assertEquals(12.53, item3.getPrice()),
                () -> assertEquals(193.2, item4.getPrice())
        );
    }

}