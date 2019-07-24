import main.Shop;
import main.ShopItem;
import main.ShopUser;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ShopItem chushki = new ShopItem(
                "Chushki",
                new BigDecimal(2.99),
                20);
        ShopItem domati = new ShopItem(
                "Domati",
                new BigDecimal(2.99),
                30);
        Shop shop = new Shop(Arrays.asList(domati, chushki));
        shop.registerUser("pesho", "123");
    }
}
