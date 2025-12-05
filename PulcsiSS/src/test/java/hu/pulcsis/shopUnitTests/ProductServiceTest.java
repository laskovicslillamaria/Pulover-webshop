package hu.pulcsis.shopUnitTests;
import hu.pulcsis.shop.model.Product;
import hu.pulcsis.shop.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void testGetAllProductsReturnsAllNineProducts() {
        ProductService service = new ProductService();

        List<Product> products = service.getAllProducts();

        assertNotNull(products);
        assertEquals(9, products.size());
    }

    @Test
    void testGetProductByIdExisting() {
        ProductService service = new ProductService();

        Product product = service.getProductById(1L);

        assertNotNull(product);
        assertEquals(1L, product.getId());
        assertEquals("Fekete kapucnis pulcsi", product.getName());
        assertEquals(8990, product.getPrice());
        assertEquals("Kapucnis", product.getCategory());
    }

    @Test
    void testGetProductByIdNotExistingReturnsNull() {
        ProductService service = new ProductService();

        Product product = service.getProductById(999L);

        assertNull(product);
    }

    @Test
    void testGetAllProductsIndependence() {
        ProductService service = new ProductService();

        List<Product> products = service.getAllProducts();
        products.clear(); // teszt: ne tudja a külső lista módosítani a belsőt

        List<Product> internal = service.getAllProducts();
        assertEquals(9, internal.size());
    }
}
