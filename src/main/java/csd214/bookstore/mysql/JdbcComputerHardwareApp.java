package csd214.bookstore.mysql;
import csd214.bookstore.pojos.ComputerHardware;
import java.sql.*;
import java.util.UUID;

public class JdbcComputerHardwareApp {
    private static final String URL = "jdbc:mysql://localhost:3333/bookstore";
    private static final String USER = "csd214";
    private static final String PASS = "itstudies12345";
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // 1. Create Table
            createTable(conn);
            // 2. Insert
            System.out.println("--- INSERTING ---");
            ComputerHardware ch1 = new ComputerHardware("Super Computer Hardware", "Master Category", 19.99) {
                @Override
                public void sellItem() {

                }
            };
            insertComputerHardware(conn, ch1);
            // 3. Read
            System.out.println("--- READING ---");
            listComputerHardware(conn);
            // 4. Update
            System.out.println("--- UPDATING ---");
            updateComputerHardwarePrice(conn, 1, 10.99);

            // 5. Delete
            System.out.println("--- DELETING ---");
            deleteComputerHardware(conn, 1);
            listComputerHardware(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS computerHardwares (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "product_id VARCHAR(36), " +
                "computer_hardware_brand VARCHAR(30), " +
                "computer_hardware_category varchar(30)" +
                "computer_hardware_price double";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'computerHardwares' ready.");
        }
    }
    private static void insertComputerHardware(Connection conn, ComputerHardware ch) throws SQLException {
        // SECURITY: Use ? to prevent SQL Injection
        String sql = "INSERT INTO computerHardwares (product_id, computer_hardware_brand, computer_hardware_category, computer_hardware_price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ch.getProductId()); // ProductID
            ps.setString(2, ch.getBrand());
            ps.setString(3, ch.getCategory());
            ps.setDouble(4, ch.getPrice());
            ps.executeUpdate();
            System.out.println("Saved: " + ch.getBrand());
        }
    }
    private static void listComputerHardware(Connection conn) throws SQLException {
        String sql = "SELECT * FROM computerHardwares";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | ProductID: %s | ComputerHardwareBrand: %s | ComputerHardwareCategory: %s| Price: $%.2f%n" ,
                        rs.getInt("id"),
                        rs.getString("product_id"),
                        rs.getString("computer_hardware_brand"),
                        rs.getString("computer_hardware_category"),
                        rs.getDouble("computer_hardware_price")
                );
            }
        }
    }
    private static void updateComputerHardwarePrice(Connection conn, int id, double newPrice) throws SQLException {
        String sql = "UPDATE widgets SET computer_hardware_price = ? WHERE product_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " computer hardware(s).");
        }
    }

    private static void deleteComputerHardware(Connection conn, int productId) throws SQLException {
        String sql = "DELETE FROM computerHardwares WHERE product_id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ps.executeUpdate();
            System.out.println("Deleted computer hardware brand: " + productId);
        }
    }
}
