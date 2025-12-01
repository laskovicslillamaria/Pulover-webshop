package hu.pulcsis.shop.service;

import hu.pulcsis.shop.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {
    private Map<Long, Product> products = new HashMap<>();

    public ProductService() {
        // Kapucnis pulcsik
        products.put(1L, new Product(1L, "Fekete kapucnis pulcsi", 8990, "Kapucnis"));
        products.put(2L, new Product(2L, "Szürke kapucnis pulcsi", 9490, "Kapucnis"));
        products.put(3L, new Product(3L, "Piros kapucnis pulcsi", 8990, "Kapucnis"));

        // Basic pulcsik
        products.put(4L, new Product(4L, "Kék basic pulcsi", 6990, "Basic"));
        products.put(5L, new Product(5L, "Fehér basic pulcsi", 5990, "Basic"));
        products.put(6L, new Product(6L, "Zöld basic pulcsi", 6490, "Basic"));

        // Sportos pulcsik
        products.put(7L, new Product(7L, "Nike sportos pulcsi", 12990, "Sportos"));
        products.put(8L, new Product(8L, "Adidas sportos pulcsi", 13490, "Sportos"));
        products.put(9L, new Product(9L, "Puma sportos pulcsi", 11990, "Sportos"));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Long id) {
        return products.get(id);
    }
}

