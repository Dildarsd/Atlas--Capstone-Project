package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class DatabaseTesting {
    private static Connection connection;
    @BeforeClass
    public static void setUp() throws SQLException {
        // Establish database connection
        String url = "jdbc:mysql://localhost:3306/amazon";
        String username = "dildar";
        String password = "dildar";
        connection = DriverManager.getConnection(url, username, password);
    }
    @AfterClass
    public static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    @Test
    public void testCreateTables() throws SQLException {
        executeUpdate("CREATE TABLE CustomerTable (customerId INT PRIMARY KEY AUTO_INCREMENT, customerName VARCHAR(255), customerPhone VARCHAR(255), customerEmail VARCHAR(255))");
        executeUpdate("CREATE TABLE SalesTable (productId INT PRIMARY KEY AUTO_INCREMENT, productName VARCHAR(255), category VARCHAR(255), price INT, currentAvailability INT, quantityInStock INT)");
        executeUpdate("CREATE TABLE OrderTable (orderId INT PRIMARY KEY AUTO_INCREMENT, customerId INT, productId INT, quantity INT, totalPrice INT, address VARCHAR(255), city VARCHAR(255), state VARCHAR(255), zipcode VARCHAR(255), " +
                "FOREIGN KEY (customerId) REFERENCES CustomerTable(customerId), " +
                "FOREIGN KEY (productId) REFERENCES SalesTable(productId))");
        insertData();
    }
    @Test
    public void testMaxPriceProduct() throws SQLException {
        // max price product query
        String query = "SELECT productName, price FROM SalesTable ORDER BY price DESC LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(query);

        try (ResultSet resultSet = statement.executeQuery()) {
            assert resultSet != null;
            if (resultSet.next()) {
                Assert.assertEquals("Iphone 15",resultSet.getString("productName")) ;
                Assert.assertEquals(85000,resultSet.getInt("price"));
            }
        }
    }
    @Test
    public void testMostSoldProduct() throws SQLException {
        //  most sold product query
        String query = "SELECT productName, SUM(quantity) as totalSold FROM OrderTable as o left join salestable as s on o.productId = s.productId GROUP BY productName ORDER BY totalSold DESC LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(query);
        try (ResultSet resultSet = statement.executeQuery()) {
            assert resultSet != null;
            if (resultSet.next()) {
                Assert.assertEquals("captain america toy", resultSet.getString("productName"));
                Assert.assertEquals(12, resultSet.getInt("totalSold"));
            }
        }
    }
    @Test
    public void testRegionWiseMostSoldProduct() throws SQLException {
        String query = "WITH RankedProducts AS (\n" +
                "    SELECT\n" +
                "        productName,\n" +
                "        MAX(quantity) AS totalSold,\n" +
                "        city,\n" +
                "        ROW_NUMBER() OVER (PARTITION BY city ORDER BY MAX(quantity) DESC) AS rn\n" +
                "    FROM\n" +
                "        (select productId, sum(quantity) as quantity, city from ordertable group by productId, city order by city, quantity desc) AS o\n" +
                "        LEFT JOIN salestable AS s ON o.productId = s.productId\n" +
                "    GROUP BY\n" +
                "        city,\n" +
                "        productName\n" +
                ")\n" +
                "SELECT\n" +
                "    city,\n" +
                "    productName,\n" +
                "    MAX(totalSold) AS totalSold\n" +
                "FROM\n" +
                "    RankedProducts\n" +
                "WHERE\n" +
                "    rn = 1\n" +
                "GROUP BY\n" +
                "    city, productName;\n" +
                "\n";
        PreparedStatement statement = connection.prepareStatement(query);
        try (ResultSet resultSet = statement.executeQuery()) {
            assert resultSet != null;
            while (resultSet.next()) {
                switch (resultSet.getString("city")) {
                    case "Chennai":
                        Assert.assertNotEquals("Iphone 13", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 14", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 15", resultSet.getString("productName"));
                        Assert.assertNotEquals("Google Pixel 7", resultSet.getString("productName"));
                        Assert.assertNotEquals("Samsung Galaxy s23", resultSet.getString("productName"));
                        Assert.assertNotEquals("HarryPotter Book", resultSet.getString("productName"));
                        Assert.assertNotEquals("Face Cream", resultSet.getString("productName"));
                        Assert.assertNotEquals("T-shirt", resultSet.getString("productName"));
                        Assert.assertNotEquals("Nike Shoes", resultSet.getString("productName"));
                        Assert.assertEquals("Captain america toy", resultSet.getString("productName"));
                        Assert.assertEquals(4, resultSet.getInt("totalSold"));
                        break;
                    case "Bengaluru":
                        Assert.assertNotEquals("Iphone 13", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 14", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 15", resultSet.getString("productName"));
                        Assert.assertNotEquals("Google Pixel 7", resultSet.getString("productName"));
                        Assert.assertNotEquals("Samsung Galaxy s23", resultSet.getString("productName"));
                        Assert.assertNotEquals("HarryPotter Book", resultSet.getString("productName"));
                        Assert.assertNotEquals("Face Cream", resultSet.getString("productName"));
                        Assert.assertNotEquals("T-shirt", resultSet.getString("productName"));
                        Assert.assertNotEquals("Nike Shoes", resultSet.getString("productName"));
                        Assert.assertEquals("captain america toy", resultSet.getString("productName"));
                        Assert.assertEquals(2, resultSet.getInt("totalSold"));
                        break;
                    case "Hyderabad":
                        Assert.assertNotEquals("Iphone 13", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 14", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 15", resultSet.getString("productName"));
                        Assert.assertNotEquals("Google Pixel 7", resultSet.getString("productName"));
                        Assert.assertNotEquals("Samsung Galaxy s23", resultSet.getString("productName"));
                        Assert.assertNotEquals("HarryPotter Book", resultSet.getString("productName"));
                        Assert.assertNotEquals("Face Cream", resultSet.getString("productName"));
                        Assert.assertNotEquals("T-shirt", resultSet.getString("productName"));
                        Assert.assertNotEquals("Nike Shoes", resultSet.getString("productName"));
                        Assert.assertEquals("captain america toy", resultSet.getString("productName"));
                        Assert.assertEquals(5, resultSet.getInt("totalSold"));
                        break;
                    case "Vijayawada":
                        Assert.assertNotEquals("Iphone 13", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 14", resultSet.getString("productName"));
                        Assert.assertNotEquals("Iphone 15", resultSet.getString("productName"));
                        Assert.assertNotEquals("Google Pixel 7", resultSet.getString("productName"));
                        Assert.assertNotEquals("Samsung Galaxy s23", resultSet.getString("productName"));
                        Assert.assertNotEquals("HarryPotter Book", resultSet.getString("productName"));
                        Assert.assertNotEquals("Captain america toy", resultSet.getString("productName"));
                        Assert.assertNotEquals("T-shirt", resultSet.getString("productName"));
                        Assert.assertNotEquals("Nike Shoes", resultSet.getString("productName"));
                        Assert.assertEquals("Face Cream", resultSet.getString("productName"));
                        Assert.assertEquals(3, resultSet.getInt("totalSold"));
                        break;
                }
            }
        }
    }
    private void insertData() throws SQLException {
//          insert data statements
        executeUpdate("INSERT INTO CustomerTable (customerName, customerPhone, customerEmail) VALUES ('Dildar', '1234567890', 'dildar@gmail.com'),('Bhargav', '1234567891', 'bhargav@gmail.com'),('Mahesh', '1234567800', 'mahesh@gmail.com'),('Sidhu', '1234567090', 'sidhu@gmail.com'),('Raj', '1234557890', 'raj@gmail.com')");
        executeUpdate("INSERT INTO SalesTable (productName, category, price, currentAvailability, quantityInStock) VALUES ('Iphone 13', 'Electronics', 55000, 1, 50),('Iphone 14', 'Electronics', 75000, 1, 60),('Iphone 15', 'Electronics', 85000, 1, 90),('Google Pixel 7', 'Electronics', 55000, 1, 50),('Samsung Galaxy s23', 'Electronics', 75000, 1, 50),('HarryPotter Book', 'Books', 750, 1, 50),('Face Cream', 'Beauty', 350, 1, 50),('captain america toy', 'Toys', 500, 1, 10),('Tshirt', 'Fashion', 600, 1, 50),('Nike Shoes', 'Fashion', 6000, 1, 50)");
        executeUpdate("INSERT INTO OrderTable (customerId, productId, quantity, totalPrice, address, city, state, zipcode) VALUES (1, 1, 1, 55000, '123 St', 'Chennai', 'TamilNadu', '600096'),(2, 2, 1, 75000, '1234 Main St', 'Bengaluru', 'Karnataka', '700001'),(3, 3, 1, 85000, '12345 Main St', 'Bengaluru', 'Karnataka', '700001'),(4, 4, 1, 55000, '123456 Main St', 'Bengaluru', 'Karnataka', '700001'),(5, 5, 1, 75000, '1237 Main St', 'Bengaluru', 'Karnataka', '700001'),(1, 6, 1, 750, '1237 Main St', 'Bengaluru', 'Karnataka', '700001'),(2, 7, 1, 350, '1237 Main St', 'Hyderabad', 'TamilNadu', '600096'),(3, 8, 1, 500, '1237 jntu St', 'chennai', 'Tamil Nadu', '600096'),(4, 9, 1, 600, '12 Main St', 'Hyderabad', 'Telangana', '500001'),(5, 10, 1, 6000, '1237 Main St', 'Bengaluru', 'Karnataka', '700001'),(5, 9, 1, 600, '12 Main St', 'Vijayawada', 'Andhra Pradesh', '400001'),(4, 9, 2, 600, '12 Main St', 'Chennai', 'Tamil Nadu', '600096'),(3, 9, 1, 600, '12 Main St', 'Bengaluru', 'Karnataka', '700001'),(2, 9, 1, 600, '12 Main St', 'Vijayawada', 'Andhra Pradesh', '400001'),(1, 9, 1, 600, '12 Main St', 'Hyderabad', 'Telangana', '500001'),(1, 7, 1, 350, '1237 Main St', 'Hyderabad', 'Telangana', '500001'),(2, 7, 3, 350, '1237 Main St', 'Vijayawada', 'Andhra Pradesh', '400001'),(3, 7, 1, 350, '1237 Main St', 'Hyderabad', 'Telangana', '500001'),(4, 7, 1, 350, '1237 Main St', 'Hyderabad', 'Telangana', '500001'),(5, 7, 2, 350, '1237 Main St', 'Chennai', 'TamilNadu', '600096'),(5, 8, 3, 500, '1237 Main St', 'Chennai', 'TamilNadu', '600096'),(4, 8, 2, 500, '1237 Main St', 'Bengaluru', 'Karnataka', '700001'),(3, 8, 1, 500, '1237 Main St', 'Chennai', 'Tamil Nadu', '600096'),(2, 8, 5, 500, '1237 Main St', 'Hyderabad', 'Telangana', '500001'),(1, 10, 1, 6000, '1237 Main St', 'Hyderabad', 'Telangana', '500001')");
    }
    private void executeUpdate(String query) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        }
    }
}
