package metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetaData {

    static Connection connection = DBConnection.getDBConnection();
    static DatabaseMetaData metaData = null;

    static {
        try {
            metaData = connection.getMetaData();
        } catch (Exception e) {
        }
    }

    public static void printGeneralMetaData() throws SQLException {
        System.out.println("Database Name: " + metaData.getDatabaseProductName());
        System.out.println("Database Version: " + metaData.getDatabaseProductVersion());
        System.out.println("Logged User: " + metaData.getUserName());
        System.out.println("JDBC Driver: " + metaData.getDriverName());
        System.out.println("Driver Version: " + metaData.getDriverVersion());
        System.out.println("\n");
    }

    public static ArrayList getTablesMetaData() throws SQLException {
        String table[] = {"TABLE"};
        ResultSet rs = null;
        ArrayList tables = null;
        // Recive the Type of the object in a String Array
        rs = metaData.getTables(null, null, null, table);
        tables = new ArrayList();
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

    public static void getColumnsMetaData(ArrayList tables) throws SQLException {
        ResultSet rs = null;
        // Print the columns properties of the actual table
        for (Object actualTable : tables) {
            rs = metaData.getColumns(null, null, actualTable.toString(), null);
            System.out.println(actualTable.toString().toUpperCase());
            while (rs.next()) {
                System.out.println(rs.getString("COLUMN_NAME") + " " + rs.getString("TYPE_NAME") + " " + rs.getString("COLUMN_SIZE"));
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        try {
            printGeneralMetaData();
            // Print all the tables of the database scheme, with their names and
            // structure
            getColumnsMetaData(getTablesMetaData());
        } catch (SQLException e) {
            System.err.println("There was an error retrieving the metadata properties: " + e.getMessage());
        }
    }
}
