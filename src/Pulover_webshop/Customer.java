package org.Pulover_webshop;

import java.util.ArrayList;

/**
 * A Customer osztály egy webshop vásárlóját reprezentálja.
 * Tartalmazza a vásárló nevét, e-mail címét, a leadott rendeléseit és a bevásárlókosár tartalmát.
 */
public class Customer {

    private String name;
    private String email;
    private ArrayList<Order> orders;
    private ArrayList<Product> cart;

    /**
     * Konstruktor egy új vásárló létrehozásához.
     *
     * @param name A vásárló neve
     * @param email A vásárló e-mail címe
     * @param orders A vásárló rendeléseinek listája
     * @param cart A vásárló bevásárlókosarának tartalma
     */
    public Customer(String name, String email, ArrayList<Order> orders, ArrayList<Product> cart) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
        this.cart = new ArrayList<>();
    }

    /** @return A vásárló neve */
    public String getName() {
        return name;
    }

    /**
     * Beállítja a vásárló nevét.
     *
     * @param name Az új név
     */
    public void setName(String name) {
        this.name = name;
    }

    /** @return A vásárló e-mail címe */
    public String getEmail() {
        return email;
    }

    /**
     * Beállítja a vásárló e-mail címét.
     *
     * @param email Az új e-mail cím
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return A vásárló rendeléseinek listája */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Beállítja a vásárló rendeléseit.
     *
     * @param orders Az új rendeléslista
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /** @return A vásárló bevásárlókosarának tartalma */
    public ArrayList<Product> getCart() {
        return cart;
    }

    /**
     * Beállítja a vásárló bevásárlókosarának tartalmát.
     *
     * @param cart Az új kosár tartalma
     */
    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
}
