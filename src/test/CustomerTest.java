package org.Pulover_webshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Automatizált teszt a Customer osztályhoz.
 */
class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", "john@example.com",
                new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void testConstructorInitializesFields() {
        assertEquals("John Doe", customer.getName());
        assertEquals("john@example.com", customer.getEmail());
        assertNotNull(customer.getOrders());
        assertNotNull(customer.getCart());
        assertTrue(customer.getOrders().isEmpty());
        assertTrue(customer.getCart().isEmpty());
    }

    @Test
    void testSetName() {
        customer.setName("Jane Smith");
        assertEquals("Jane Smith", customer.getName());
    }

    @Test
    void testSetEmail() {
        customer.setEmail("jane@example.com");
        assertEquals("jane@example.com", customer.getEmail());
    }

    @Test
    void testSetOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order()); // feltételezve, hogy van paraméter nélküli Order konstruktor
        customer.setOrders(orders);

        assertEquals(1, customer.getOrders().size());
        assertSame(orders, customer.getOrders());
    }

    @Test
    void testSetCart() {
        ArrayList<Product> cart = new ArrayList<>();
        cart.add(new Product()); // feltételezve, hogy van paraméter nélküli Product konstruktor
        customer.setCart(cart);

        assertEquals(1, customer.getCart().size());
        assertSame(cart, customer.getCart());
    }
}