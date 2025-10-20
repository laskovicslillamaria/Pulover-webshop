package org.Pulover_webshop;

import java.util.ArrayList;

/**
 * A Webshop osztály egy online áruház adatait tárolja.
 * Tartalmazza a webshop nevét, domain címét, a termékek listáját és a vásárlói rendeléseket.
 */
public class Webshop {

    private String name;
    private String domain;
    private ArrayList<Product> products;
    private ArrayList<Order> customers;

    /**
     * Konstruktor egy új webshop létrehozásához.
     *
     * @param name A webshop neve
     * @param domain A webshop domain címe (pl. www.pulover.hu)
     */
    public Webshop(String name, String domain){
        this.name = name;
        this.domain = domain;
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    /** @return A webshop neve */
    public String getName() {
        return name;
    }

    /**
     * Beállítja a webshop nevét.
     *
     * @param name Az új név
     */
    public void setName(String name) {
        this.name = name;
    }

    /** @return A webshop domain címe */
    public String getDomain() {
        return domain;
    }

    /**
     * Beállítja a webshop domain címét.
     *
     * @param domain Az új domain cím
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /** @return A webshop termékeinek listája */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Beállítja a webshop termékeinek listáját.
     *
     * @param products Az új terméklista
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    /** @return A webshop vásárlói rendeléseinek listája */
    public ArrayList<Order> getCustomers() {
        return customers;
    }

    /**
     * Beállítja a webshop vásárlói rendeléseit.
     *
     * @param customers Az új rendeléslista
     */
    public void setCustomers(ArrayList<Order> customers) {
        this.customers = customers;
    }
}
