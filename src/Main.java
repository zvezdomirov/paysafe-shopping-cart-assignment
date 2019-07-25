import main.constants.Commands;
import main.exceptions.NoSuchItemException;
import main.exceptions.PasswordNotMatchingException;
import main.models.shop.Shop;
import main.models.shop.ShopItem;
import main.models.user.ShopUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        Shop shop = new Shop(Shop.generateRandomItemList());
        System.out.println(shop.listAvailableItems());

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String currentLine = br.readLine();
        ShopUser user = null;
        /*Breaks loop when "checkout" is read,
        * but first check if user is not null*/
        while (true) {
            String[] tokens = currentLine.split("\\s+");
            String command = tokens[0];
            if (command.equals(Commands.REGISTER.toString())) {
                shop.registerUser(tokens[1], tokens[2]);
            } else if (command.equals(Commands.LOGIN.toString())) {
                try {
                    user = shop.loginUser(tokens[1], tokens[2]);
                } catch (PasswordNotMatchingException e) {
                    System.out.println("Wrong password for user: "
                            + tokens[1]);
                }
            } else if (user == null) {
                System.out.println("This command requires you to be logged in!");
            } else if (command.equals(Commands.ADD.toString())) {
                try {
                    user.addToCart(shop.getItem(
                            Integer.parseInt(tokens[1])),
                            Integer.parseInt(tokens[2]));
                } catch (NoSuchItemException e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equals(Commands.REMOVE.toString())) {
                user.removeFromCart(shop.getItem(
                        Integer.parseInt(tokens[1])),
                        Integer.parseInt(tokens[2]));
            } else if (command.equals(Commands.REVIEW.toString())) {
                System.out.println(user.reviewCart());
            } else if (command.equals(Commands.CHECKOUT.toString())) {
                System.out.println(user.checkout());
                return;
            } else {
                System.out.println("Invalid command.");
            }
            currentLine = br.readLine();
        }
    }
}
