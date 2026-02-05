package csd214.bookstore.mysql;
import csd214.bookstore.pojos.Pen;
import csd214.bookstore.pojos.Stationery;
import csd214.bookstore.pojos.Widget;

import java.sql.*;
import java.util.UUID;

public class JdbcStationery extends Stationery{
    private static final String URL = "jdbc:mysql://localhost:3333/bookstore";
    private static final String USER = "csd214";
    private static final String PASS = "itstudies12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            // 1. Create Table
            createTableStationery(conn);
            createTablePen(conn);
            // 2. Insert
            System.out.println("--- INSERTING ---");
            Pen s1 = new Pen("Super Stationery", "Red", 19.99);
            insertStationery(conn, s1);
            // 3. Read
            System.out.println("--- READING ---");
            listStationery(conn);
            // 4. Update
            System.out.println("--- UPDATING ---");
            updateStationeryPrice(conn, "Super Widget", 25.50);

            // 5. Delete
            System.out.println("--- DELETING ---");
            deleteStationery(conn, "Super Widget");
            listStationery(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createTableStationery(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS stationeries (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "stationery_id VARCHAR(36), " +
                "stationery_brand VARCHAR(255), " +
                "price DOUBLE)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'Stationery' ready.");
        }
    }

    private static void createTablePen(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pens (" +
                "stationery_id INT AUTO_INCREMENT PRIMARY FOREIGN KEY, " +
                "product_id VARCHAR(36), " +
                "stationery_brand VARCHAR(255), " +
                "color VARCHAR(15))";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'Stationery' ready.");
        }
    }
    private static void insertWidget(Connection conn, Widget w) throws SQLException {
        // SECURITY: Use ? to prevent SQL Injection
        String sql = "INSERT INTO widgets (stationery_id, widget_name, price) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, w.getProductId()); // UUID
            ps.setString(2, w.getWidgetName());
            ps.setDouble(3, w.getPrice());
            ps.executeUpdate();
            System.out.println("Saved: " + w.getWidgetName());
        }
    }

    private static void listWidgets(Connection conn) throws SQLException {
        String sql = "SELECT * FROM widgets";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | UUID: %s | Name: %s | Price: $%.2f%n",
                        rs.getInt("id"),
                        rs.getString("stationery_id"),
                        rs.getString("widget_name"),
                        rs.getDouble("price"));
            }
        }
    }
    private static void updateWidgetPrice(Connection conn, String name, double newPrice) throws SQLException {
        String sql = "UPDATE widgets SET price = ? WHERE widget_name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setString(2, name);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " widget(s).");
        }
    }

    private static void deleteWidget(Connection conn, String name) throws SQLException {
        String sql = "DELETE FROM widgets WHERE widget_name = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("Deleted widget: " + name);
        }
    }
}
