package csd214.bookstore.pojos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MouseTest {
    @Test
    void mouseTestConstructor() {
        Mouse mouse = new Mouse("Logitech", 6, 24000, 119.99);
        assertEquals("Logitech", mouse.getBrand());
        assertEquals(6, mouse.getNumOfButtons());
        assertEquals(24000, mouse.getDpi());
    }
} 
