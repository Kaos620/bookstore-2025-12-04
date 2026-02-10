package csd214.bookstore.mysql;

import csd214.bookstore.pojos.Mouse;
import java.sql.*;

public class JdbcMouseApp {
    private static final String URL = "jdbc:mysql://localhost:3333/bookstore";
    private static final String USER = "csd214";
    private static final String PASS = "itstudies12345";
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // 1. Create Table
            createTable(conn);
            // 2. Insert
            System.out.println("--- INSERTING ---");
            Mouse mouse = new Mouse ("Logitech", 6, 16000, 150.00);
            insertMouse(conn, mouse);
            // 3. Read
            System.out.println("--- READING ---");
            listMouse(conn);
            // 4. Update
            System.out.println("--- UPDATING ---");
            updateMousePrice(conn, "Logitech", 25.50);

            // 5. Delete
            System.out.println("--- DELETING ---");
            deletePen(conn, "Logitech");
            listWidgets(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS mouse (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "product_id VARCHAR(36), " +
                "brand VARCHAR(255), " +
                "DPI int, " +
                "num_of_buttons int, " +
                "price DOUBLE)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'mouse' ready.");
        }
    }
    private static void insertMouse(Connection conn, Mouse m) throws SQLException {
        // SECURITY: Use ? to prevent SQL Injection
        String sql = "INSERT INTO mouse (product_id, brand, dpi, num_of_buttons,price ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getProductId()); // UUID
            ps.setString(2, m.getBrand());
            ps.setInt(3, m.getDpi());
            ps.setInt(4, m.getNumOfButtons());
            ps.setDouble(5, m.getPrice());
            ps.executeUpdate();
            System.out.println("Saved: " + m.toString());
        }
    }
    private static void listMouse(Connection conn) throws SQLException {
        String sql = "SELECT * FROM mouse";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | UUID: %s | Brand: %s | DPI: %d | NoButtons: %d | Price: $%.2f%n",
                        rs.getInt("id"),
                        rs.getString("product_id"),
                        rs.getString("brand"),
                        rs.getInt("dpi"),
                        rs.getInt("num_of_buttons"),
                        rs.getDouble("price"));
            }
        }
    }
    private static void updatePenPrice(Connection conn, String brand, double newPrice) throws SQLException {
        String sql = "UPDATE pen SET price = ? WHERE brand = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setString(2, brand);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " pen(s).");
        }
    }

    private static void deletePen(Connection conn, String brand) throws SQLException {
        String sql = "DELETE FROM pen WHERE brand = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, brand);
            ps.executeUpdate();
            System.out.println("Deleted pen: " + brand);
        }
    }
}
