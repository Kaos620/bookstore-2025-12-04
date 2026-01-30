package csd214.bookstore.pojos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotebookTest {
    @Test
    void testEquality() {
        // Arrange
        Notebook nt1 = new Notebook("Pilot", 300, 10.99);
        Notebook nt2 = new Notebook("Pilot", 300, 10.99);
        Notebook nt3 = new Notebook("Pilot", 150, 4.99);
        // Act & Assert
        assertEquals(nt1, nt2, "Notebook with same state should be equal");
        assertEquals(nt1.hashCode(), nt2.hashCode(), "HashCodes must match");
        assertNotEquals(nt1, nt3, "Different page count should not be equal");
    }
}
