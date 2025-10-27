package org.Pulover_webshop;

import java.util.ArrayList;
import java.util.Date;

/**
 * Az Order osztály egy webshopban leadott rendelést reprezentál.
 * Tartalmazza a rendelés azonosítóját, a vásárló adatait, a rendelt termékek listáját,
 * a teljes összeget, a rendelés dátumát és a feldolgozottsági állapotot.
 */
public class Order {

    private String orderId;
    private Customer customer;
    private ArrayList<Product> products;
    private double totalAmount;
    private Date orderDate;
    private boolean processed;

    /**
     * Konstruktor egy új rendelés létrehozásához.
     *
     * @param orderId A rendelés azonosítója
     * @param customer A rendelést leadó vásárló
     * @param products A rendelésben szereplő termékek listája
     * @param totalAmount A rendelés teljes összege
     * @param orderDate A rendelés dátuma
     * @param processed A rendelés feldolgozottsági állapota (true = feldolgozott)
     */
    public Order(String orderId, Customer customer, ArrayList<Product> products, double totalAmount, Date orderDate, boolean processed) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.processed = processed;
    }

    /** @return A rendelés azonosítója */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Beállítja a rendelés azonosítóját.
     *
     * @param orderId Az új rendelésazonosító
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /** @return A rendelést leadó vásárló */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Beállítja a rendeléshez tartozó vásárlót.
     *
     * @param customer Az új vásárló objektum
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /** @return A rendelésben szereplő termékek listája */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Beállítja a rendelés termékeinek listáját.
     *
     * @param products Az új terméklista
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /** @return A rendelés teljes összege */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Beállítja a rendelés teljes összegét.
     *
     * @param totalAmount Az új összeg (Ft)
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /** @return A rendelés dátuma */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Beállítja a rendelés dátumát.
     *
     * @param orderDate Az új rendelési dátum
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /** @return Igaz, ha a rendelés már feldolgozott */
    public boolean isProcessed() {
        return processed;
    }

    /**
     * Beállítja a rendelés feldolgozottsági állapotát.
     *
     * @param processed true, ha a rendelés feldolgozott, false, ha még nem
     */
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }


    /**
     * Létrehoz egy új rendelést a megadott vásárló kosara alapján.
     *
     * @param customer A vásárló, akinek a kosara alapján a rendelés készül
     * @return Az új rendelés objektum
     */
    public static Order createOrderFromCart(Customer customer) {
        if (customer == null || customer.getCart().isEmpty()) {
            System.out.println("A kosár üres, nem hozható létre rendelés.");
            return null;
        }
        ArrayList<Product> productsInOrder = new ArrayList<>(customer.getCart());
        double total = 0;
        for (Product product : productsInOrder) {
            total += product.getPrice();
            product.decreaseStock(1); // minden termékből 1 db-ot rendelünk
        }
        Order order = new Order(
                "ORD-" + System.currentTimeMillis(),
                customer,
                productsInOrder,
                total,
                new java.util.Date(),
                false
        );
        customer.getOrders().add(order);
        customer.getCart().clear();

        System.out.println("Rendelés sikeresen létrehozva. Összeg: " + total + " Ft");

        return order;
    }

}
