package hu.pulcsis.shop.Controller;

import hu.pulcsis.shop.model.CartItem;
import hu.pulcsis.shop.model.Product;
import hu.pulcsis.shop.service.CartService;
import hu.pulcsis.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ShopController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/cart/add/{id}")
    public ResponseEntity<String> addToCart(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if (product != null) {
            cartService.addToCart(product);
            return ResponseEntity.ok("Termék hozzáadva");
        }
        return ResponseEntity.badRequest().body("Termék nem található");
    }

    @GetMapping("/cart")
    public List<CartItem> getCart() {
        return cartService.getCartItems(); // JAVÍTVA: getCart() → getCartItems()
    }

    @GetMapping("/cart/total")
    public int getCartTotal() {
        return cartService.getTotal();
    }

    @DeleteMapping("/cart/clear")
    public ResponseEntity<String> clearCart() {
        cartService.clearCart();
        return ResponseEntity.ok("Kosár törölve");
    }
}