import java.util.ArrayList;
import java.util.List;


public class ShoppinCart {
    private List<Item> items = new ArrayList<Item>();


    public ShoppinCart(){}

    public void addItemToCart(Item i) {
        this.items.add(i);
    }

    public double calculateTotal() {
        double amount = 0;
        for (Item i : items) {
            amount += i.getPrice();
        }
        return amount;
    }
}
