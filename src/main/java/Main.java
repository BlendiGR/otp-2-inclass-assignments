import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        ShoppinCart cart = new ShoppinCart();

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int numberAmount;

        System.out.println("Select language: 1=English, 2=Finnish, 3=Swedish, 4=Japanese");
        int choice = scanner.nextInt();

        Locale locale = switch (choice) {
            case 2 -> new Locale("fi", "FI");
            case 3 -> new Locale("sv", "SE");
            case 4 -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(messages.getString("prompt.items"));
        numberAmount = scanner.nextInt();

        for (int i = 0; i < numberAmount; i++){
            int quantity;
            double price;
            System.out.println(messages.getString("prompt.item") + "[" + (i+1) + "] " + messages.getString("prompt.price"));
            price = scanner.nextDouble();

            System.out.println(messages.getString("prompt.quantity"));
            quantity = scanner.nextInt();

            for (int y = 0; y < quantity; y++){
                Item item = new Item(price);
                cart.addItemToCart(item);
            }
        }

        System.out.println(messages.getString("prompt.total") + cart.calculateTotal() + " €!" );
    }

}
