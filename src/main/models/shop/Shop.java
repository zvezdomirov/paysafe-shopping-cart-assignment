package main.models.shop;

import main.exceptions.PasswordNotMatchingException;
import main.exceptions.UserNotRegisteredException;
import main.models.user.ShopUser;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

public class Shop {
    private static final String ITEM_LISTING_MESSAGE
            = "List of available items in the shop:\n";
    private Map<Integer, ShopItem> itemsAvailable;
    private Map<String, ShopUser> users;

    public Shop(List<ShopItem> initialItems) {
        itemsAvailable = new HashMap<>();
        users = new HashMap<>();
        initialItems
                .forEach(it -> itemsAvailable.put(it.getId(), it));

    }

    public ShopItem getItem(Integer itemId) {
        return itemsAvailable.get(itemId);
    }

    public static List<ShopItem> generateRandomItemList() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final int ITEM_LIMIT = 10;
        final int PRICE_LIMIT = 10;
        List<ShopItem> result = new ArrayList<>();

        //Generate random whole number from 1 to ITEM_LIMIT
        long randItemCount = Math.round(
                Math.random() * ITEM_LIMIT + 1);
        for (long i = 0; i < randItemCount; i++) {
            double randPrice
                    = Math.random() * PRICE_LIMIT + 1;
            ShopItem current = ShopItem.class
                    .getConstructor(String.class, BigDecimal.class)
                    .newInstance("Item " + i,
                            BigDecimal.valueOf(randPrice));
            result.add(current);
        }
        return result;
    }

    public String listAvailableItems() {
        StringBuilder result = new StringBuilder()
                .append(ITEM_LISTING_MESSAGE);
        for (ShopItem item : itemsAvailable.values()) {
            result.append(item.toString())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

    public ShopUser loginUser(String username,
                              String password)
            throws PasswordNotMatchingException {
        ShopUser user = null;
        try {
            user = getUser(username, password);
        } catch (UserNotRegisteredException e) {
            registerUser(username, password);
        }
        return user;
    }

    public void registerUser(String username, String password) {
        ShopUser user = new ShopUser(username, password, new ShoppingCart());
        users.put(username, user);
    }

    private ShopUser getUser(String username,
                             String password)
            throws UserNotRegisteredException,
                    PasswordNotMatchingException {
        ShopUser user = users.get(username);
        if (user == null) {
            throw new UserNotRegisteredException(
                            "User: " + username
                            + " is not registered"
            );
        } else if (!user.getPassword().equals(password)){
            throw new PasswordNotMatchingException(
                    "Password mismatch for username: " + username
            );
        } else {
            return user;
        }
    }
//    public Shop(List<ShopItem> initialItems) {
//        this.itemsAvailable = new HashMap<>();
//        this.cart = new ShoppingCart();
//        initialItems
//                .forEach(it -> itemsAvailable.put(it.getId(), it));
//    }
//
//    public boolean addToCart(Integer itemId,
//                             Integer quantity) {
//        ShopItem itemToAdd = itemsAvailable.get(itemId);
//        if (itemToAdd != null &&
//                itemToAdd.getQuantity() >= quantity) {
//            cart.addItem(itemToAdd);
//            itemToAdd.setQuantity(
//                    itemToAdd.getQuantity() - quantity
//            );
//            return true;
//        }
//        return false;
//    }
//
//    public BigDecimal checkout() {
//        BigDecimal totalPrice
//                = this.cart.getTotalPrice();
//        this.cart.clearCart();
//        return totalPrice;
//    }
//
//    public String reviewCartContent() {
//        return cart.reviewContent();
//    }
}
