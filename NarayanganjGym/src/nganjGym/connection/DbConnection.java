package nganjGym.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    static Connection connection = null;

    public static Connection getDBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/nganjgym", "root", "1234");
            System.out.println("Connected");
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Connection getConnectionMenually(String host, String port, String dbName,
            String userName, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql//" + host + ":" + port
                    + "/" + dbName, userName, password);
            System.out.println("Connected");
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
