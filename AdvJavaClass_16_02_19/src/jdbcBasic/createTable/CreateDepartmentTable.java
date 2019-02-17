package jdbcBasic.createTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbcBasic.DataBaseConnection;

public class CreateDepartmentTable {

    static Connection connection = DataBaseConnection.getDBconnection();

    public static void createDepartmentTable() {
        String sql = "create table department(id int(10) primary key auto_increment, depName varchar(30) not null)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Department Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(CreateDepartmentTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
