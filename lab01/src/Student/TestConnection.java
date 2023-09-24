package Student;

import java.sql.*;

public class TestConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connectionUrl =
                "jdbc:oracle:thin:@//ns.duan-dky.me:37467/pdborcl";

        try (Connection connection = DriverManager.getConnection(connectionUrl,"scott", "scott");) {
            System.out.println("连接成功");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}