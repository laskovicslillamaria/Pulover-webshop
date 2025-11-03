package org.Pulover_webshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tesztek a Product osztályhoz.
 * Teszteli a készletműveleteket, árbeállítást és érvényes adatokat.
 */
class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Pulóver", 4990.0, "Kék pamut pulóver", 10);
    }

    @Test
    void testIncreaseStock_validAmount() {
        product.increaseStock(5);
        assertEquals(15, product.getStockQuantity(),
                "A készletnek 15-nek kell lennie, ha 5-tel növeljük.");
    }

    @Test
    void testIncreaseStock_invalidAmount() {
        product.increaseStock(-3);
        assertEquals(10, product.getStockQuantity(),
                "Negatív növelés nem módosíthatja a készletet.");
    }

    @Test
    void testDecreaseStock_validAmount() {
        product.decreaseStock(4);
        assertEquals(6, product.getStockQuantity(),
                "A készletnek 6-nak kell lennie 4-gyel való csökkentés után.");
    }

    @Test
    void testDecreaseStock_insufficientStock() {
        product.decreaseStock(20);
        assertEquals(10, product.getStockQuantity(),
                "Nem lehet többet levonni, mint amennyi a készlet.");
    }

    @Test
    void testSetPrice_validValue() {
        product.setPrice(5990.0);
        assertEquals(5990.0, product.getPrice(),
                "Az árnak 5990 Ft-ra kell módosulnia.");
    }

    @Test
    void testSetPrice_negativeValue() {
        product.setPrice(-2000.0);
        assertEquals(4990.0, product.getPrice(),
                "Negatív ár nem módosíthatja az értéket.");
    }

    @Test
    void testSetName_validValue() {
        product.setName("Új Pulóver");
        assertEquals("Új Pulóver", product.getName(),
                "A névnek 'Új Pulóver'-re kell változnia.");
    }

    @Test
    void testSetName_emptyString() {
        product.setName("");
        assertEquals("Pulóver", product.getName(),
                "Üres név nem módosíthatja az eredeti értéket.");
    }

    @Test
    void testToStringFormat() {
        String text = product.toString();
        assertTrue(text.contains("Pulóver"));
        assertTrue(text.contains("Ft"));
        assertTrue(text.contains("raktáron"));
    }
}

