package main;

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

    public ShopUser registerUser(String username, String password) {
        ShopUser user = new ShopUser(username, password, new ShoppingCart());
        users.put(username, user);
        return user;
    }

    public ShopItem getItem(Integer itemId) {
        return itemsAvailable.get(itemId);
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
            user = registerUser(username, password);
        }
        return user;
    }

    private ShopUser getUser(String username,
                             String password)
            throws UserNotRegisteredException,
                    PasswordNotMatchingException {
        ShopUser user = users.get(username);
        if (user == null) {
            throw new UserNotRegisteredException();
        } else if (!user.getPassword().equals(password)){
            throw new PasswordNotMatchingException();
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
