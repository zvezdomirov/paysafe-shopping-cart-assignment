package main;

import java.math.BigDecimal;
import java.util.*;

public class Shop {

    private Map<Integer, ShopItem> itemsAvailable;
    private Map<String, ShopUser> users;

    public Shop(List<ShopItem> initialItems) {
        itemsAvailable = new HashMap<>();
        users = new HashMap<>();
        initialItems
                .forEach(it -> itemsAvailable.put(it.getId(), it));
    }

    public void registerUser(String username, String password) {
        ShopUser user = new ShopUser(username, password, new ShoppingCart());
        users.put(username, user);
    }

    public String listAvailableItems() {
        return null;
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
