import csd214.bookstore.App;
import org.junit.jupiter.api.Test;
import csd214.bookstore.pojos.*;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest{
    @Test
    void testAppFlow_AddPen() {
        // 1. Build the Script
        StringBuilder script = new StringBuilder();
        script.append("1\n");        // Main Menu: Add Items
        script.append("6\n");        // Add Menu: Add Pen (Assuming 5 is Pen)
        script.append("Bic\n");      // Brand (Stationery)
        script.append("Blue\n");     // Color (Pen)
        script.append("10\n");       // Copies (Stationery/Product)
        script.append("1.50\n");     // Price (Stationery/Product)
        script.append("99\n");       // Exit Add Menu
        script.append("99\n");       // Quit App
        // 2. Inject
        System.setIn(new ByteArrayInputStream(script.toString().getBytes()));
        // 3. Run
        App app = new App() {
            @Override
            public void populate() { /* empty to ensure clean state */ }
        };
        app.run();
        // 4. Verify
        Pen expected = new Pen("Bic", "Blue", 1.50);
        SaleableItem result = app.findItem(expected);

        assertNotNull(result, "The App should contain the Blue Bic Pen we added via console");
    }
}


