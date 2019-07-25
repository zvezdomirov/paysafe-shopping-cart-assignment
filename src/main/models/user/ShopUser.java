package main.models.user;

import main.exceptions.NoSuchItemException;
import main.models.shop.ShopItem;
import main.models.shop.ShoppingCart;

import java.math.BigDecimal;

public class ShopUser extends OnlineUser{
    private static final String CHECKOUT_MESSAGE_TEMPLATE
            = "Thank you for shopping here!\nYour bill has a total of %s";
    private ShoppingCart cart;

    public ShopUser(String username, String password, ShoppingCart cart) {
        super(username, password);
        this.cart = cart;
    }

    public void addToCart(ShopItem item,
                          Integer quantity) throws NoSuchItemException {
        cart.addItem(item, quantity);
    }

    public boolean removeFromCart(ShopItem item,
                                  Integer quantity) {
        return cart.removeItem(item, quantity);
    }

    public String checkout() {
        String message = String.format(
                CHECKOUT_MESSAGE_TEMPLATE,
                cart.getTotalPrice());
        cart.clearCart();
        return message;
    }

    public BigDecimal getCartContentPrice() {
        return cart.getTotalPrice();
    }
    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public String reviewCart() {
        return cart.reviewContent();
    }
}
