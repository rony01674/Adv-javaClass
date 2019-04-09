/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganjGym.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nganjGym.connection.DbConnection;
import nganjGym.dao.MyAccountDao;
import nganjGym.pojo.Login;
import nganjGym.pojo.MyAccount;

/**
 *
 * @author Asaduzzaman Rony
 */
public class MyAccountImplementation implements MyAccountDao {

    Connection connection = DbConnection.getDBConnection();

    @Override
//    private int insID;
//    private String fname;
//    private String userName;
//    private Date birthday;
//    private String gender;
//    private String bloodGroup;
//    private String address;
//    private String contact;
//    private String email;
    public void createTable() {
        String sql = "create table IF NOT EXISTS register(ins_id varchar(10)"
                + " primary key, first_name varchar (30), last_name varchar (20), birthday varchar (20),"
                + " gender varchar (8), address varchar (100), contact varchar (14) unique, email varchar (30)"
                + " unique, password varchar (30))";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(MyAccount myAccount) {
        String sql = "insert into register(ins_id, first_name, last_name, birthday, gender, address,"
                + " contact, email, password) values(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, myAccount.getInsID());
            ps.setString(2, myAccount.getFname());
            ps.setString(3, myAccount.getLname());
            ps.setString(4, myAccount.getBirthday());
            ps.setString(5, myAccount.getGender());
            ps.setString(6, myAccount.getAddress());
            ps.setString(7, myAccount.getContact());
            ps.setString(8, myAccount.getEmail());
            ps.setString(9, myAccount.getPassword());
            ps.executeUpdate();
            System.out.println("Insert successfull");

        } catch (SQLException ex) {
            Logger.getLogger(RegisterImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(MyAccount myAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MyAccount getUserByID(String insID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String insID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MyAccount> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
