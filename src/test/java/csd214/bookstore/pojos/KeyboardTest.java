package csd214.bookstore.pojos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KeyboardTest {
    @Test
    void testSellItem() {
        Keyboard kb = new Keyboard("Dell", 65, false, 10);
        kb.sellItem();
        assertEquals(9, kb.getStock(), "The stock test should match");
    }
}
