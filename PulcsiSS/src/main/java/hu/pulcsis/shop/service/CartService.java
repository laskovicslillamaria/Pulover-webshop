package hu.pulcsis.shop.service;

import hu.pulcsis.shop.model.CartItem;
import hu.pulcsis.shop.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    private Map<Long, CartItem> cart = new HashMap<>();

    public void addToCart(Product product) {
        if (cart.containsKey(product.getId())) {
            CartItem item = cart.get(product.getId());
            item.setQuantity(item.getQuantity() + 1);
        } else {
            cart.put(product.getId(), new CartItem(product, 1));
        }
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cart.values());
    }

    public int getTotal() {  // ÚJ METÓDUS!
        return cart.values().stream()
                .mapToInt(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public void clearCart() {
        cart.clear();
    }
}