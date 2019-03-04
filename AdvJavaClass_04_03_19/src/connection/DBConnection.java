package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    static Connection connection = null;

    public static Connection getDBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesmgnt", "root", "1234");
            System.out.println("Connected");
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
