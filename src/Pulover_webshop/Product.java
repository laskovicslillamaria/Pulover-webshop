package org.Pulover_webshop;
/**
 * A Product osztály egy webáruház termékét reprezentálja.
 * Tartalmazza a termék nevét, árát, leírását és a készleten lévő mennyiséget.
 */
public class Product {

    private String name;
    private double price;
    private String description;
    private int stockQuantity;

    /**
     * Konstruktor egy új termék létrehozásához.
     *
     * @param name A termék neve
     * @param price A termék ára
     * @param description A termék rövid leírása
     * @param stockQuantity A készleten lévő mennyiség
     */
    public Product(String name, double price, String description, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
    }

    /** @return A termék neve */
    public String getName() {
        return name;
    }

    /** @return A termék ára */
    public double getPrice() {
        return price;
    }

    /** @return A termék leírása */
    public String getDescription() {
        return description;
    }

    /** @return A készleten lévő mennyiség */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Beállítja a termék nevét.
     *
     * @param name Az új név
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("A termék neve nem lehet üres!");
        }
    }

    /**
     * Beállítja a termék árát.
     *
     * @param price Az új ár (nem lehet negatív)
     */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Az ár nem lehet negatív!");
        }
    }

    /**
     * Beállítja a termék leírását.
     *
     * @param description Az új leírás
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Beállítja a készlet mennyiségét.
     *
     * @param stockQuantity Az új készlet (nem lehet negatív)
     */
    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        } else {
            System.out.println("A készlet nem lehet negatív!");
        }
    }

    /**
     * Növeli a készlet mennyiségét.
     *
     * @param amount A növelés mértéke (pozitív szám)
     */
    public void increaseStock(int amount) {
        if (amount > 0) {
            stockQuantity += amount;
            System.out.println(amount + " db hozzáadva a készlethez. Aktuális készlet: " + stockQuantity);
        } else {
            System.out.println("A növelés értéke érvénytelen!");
        }
    }

    /**
     * Csökkenti a készlet mennyiségét.
     *
     * @param amount A csökkentés mértéke (pozitív szám, nem haladhatja meg a készletet)
     */
    public void decreaseStock(int amount) {
        if (amount > 0 && stockQuantity >= amount) {
            stockQuantity -= amount;
            System.out.println(amount + " db levonva a készletből. Aktuális készlet: " + stockQuantity);
        } else {
            System.out.println("Érvénytelen művelet! Nincs elegendő készlet.");
        }
    }

    /**
     * A termék adatait szövegként adja vissza.
     *
     * @return A termék neve, ára és készlete formázott szövegként
     */
    @Override
    public String toString() {
        return name + " - " + price + " Ft (" + stockQuantity + " db raktáron)";
    }
}
