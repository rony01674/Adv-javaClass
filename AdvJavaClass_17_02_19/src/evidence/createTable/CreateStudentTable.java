package evidence.createTable;

import evidence.connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateStudentTable {

    static Connection connection = DbConnection.getDBconnection();

    public static void createStudentTable() {
        String sql = "CREATE TABLE student (\n" +
"  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
"  `name` VARCHAR(45) NOT NULL,\n" +
"  `age` INTEGER UNSIGNED NOT NULL,\n" +
"  `email` VARCHAR(45) NOT NULL,\n" +
"  `gender` VARCHAR(45) NOT NULL,\n" +
"  `complete course` VARCHAR(45) NOT NULL,\n" +
"  `round` VARCHAR(45) NOT NULL,\n" +
"  `message` VARCHAR(45) NOT NULL,\n" +
"  PRIMARY KEY (`id`)\n" +
")";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Student Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(CreateStudentTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
