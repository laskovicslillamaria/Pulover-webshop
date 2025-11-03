package org.Pulover_webshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Teszteli az Order osztály működését.
 */
public class OrderTest {

    private Customer customer;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setup() {
        // Egyszerű példányosítás - feltételezzük, hogy van alap konstruktor és getter/setter
        customer = new Customer("Teszt Elek", "teszt@example.com");

        product1 = new Product("P001", "Kék pulóver", 14990.0, 5);
        product2 = new Product("P002", "Fekete pulóver", 15990.0, 3);

        // Termékek a kosárba
        customer.getCart().add(product1);
        customer.getCart().add(product2);
    }

    @Test
    void testCreateOrderFromCart_createsValidOrder() {
        // ACT
        Order order = Order.createOrderFromCart(customer);

        // ASSERT
        assertNotNull(order, "A rendelésnek létre kell jönnie");
        assertEquals(2, order.getProducts().size(), "A rendelésben két terméknek kell szerepelnie");
        assertEquals(customer, order.getCustomer());
        assertTrue(customer.getCart().isEmpty(), "A rendelés után a kosárnak üresnek kell lennie");
        assertFalse(order.isProcessed(), "Az új rendelés nem lehet feldolgozott");
        assertTrue(order.getTotalAmount() > 0, "A rendelés összegének pozitívnak kell lennie");
        assertNotNull(order.getOrderDate(), "A rendelés dátuma nem lehet null");
    }

    @Test
    void testCreateOrderFromCart_reducesStock() {
        int stockBefore = product1.getStock();
        Order.createOrderFromCart(customer);
        assertEquals(stockBefore - 1, product1.getStock(), "A termék készletének csökkennie kell");
    }

    @Test
    void testCreateOrderFromCart_emptyCart_returnsNull() {
        customer.getCart().clear();
        Order order = Order.createOrderFromCart(customer);
        assertNull(order, "Üres kosár esetén nem jöhet létre rendelés");
    }

    @Test
    void testCreateOrderFromCart_nullCustomer_returnsNull() {
        Order order = Order.createOrderFromCart(null);
        assertNull(order, "Null vásárló esetén nem jöhet létre rendelés");
    }
}