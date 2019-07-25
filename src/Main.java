import main.*;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ShopItem chushki = new ShopItem(
                "Chushki",
                new BigDecimal(2.99));
        ShopItem domati = new ShopItem(
                "Domati",
                new BigDecimal(1));
        Shop shop = new Shop(Arrays.asList(domati, chushki));
        System.out.println(shop.listAvailableItems());

        try {
            ShopUser pesho = shop.loginUser(
                    "pesho", "123");
            pesho.addToCart(shop.getItem(1), 5);
            pesho.addToCart(shop.getItem(1), 5);
            System.out.println(pesho.getCartContentPrice().toString());
            pesho.removeFromCart(shop.getItem(1), 3);
            System.out.println(pesho.getCartContentPrice().toString());
            System.out.println(pesho.reviewCart());
            System.out.println(pesho.checkout());
        } catch (PasswordNotMatchingException e) {
            System.out.println("Password mismatch!");
        }
    }
}
