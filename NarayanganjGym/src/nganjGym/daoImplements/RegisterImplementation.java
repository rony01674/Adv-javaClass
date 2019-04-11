/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganjGym.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nganjGym.connection.DbConnection;
import nganjGym.dao.RegisterDao;
import nganjGym.pojo.Register;

/**
 *
 * @author Asaduzzaman Rony
 */
public class RegisterImplementation implements RegisterDao {
    
    public static void main(String[] args) {
        new RegisterImplementation().createTable();
    }
    
    Connection connection = DbConnection.getDBConnection();

//    private int insId;
//    private String fname;
//    private String lname;
//    private Date birthday;
//    private String gender;
//    private String address;
//    private String contact;
//    private String email;
//    private String password;
    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS register(ins_id varchar(10)"
                + " primary key, first_name varchar (30), last_name varchar (20), birthday varchar (20),"
                + " gender varchar (8), blood_group varchar(10), address varchar (100), contact varchar (14) unique, email varchar (30)"
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
    public void save(Register register) {
        String sql = "insert into register(ins_id, first_name, last_name, birthday, gender, blood_group, address,"
                + " contact, email, password) values(?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, register.getInsId());
            ps.setString(2, register.getFname());
            ps.setString(3, register.getLname());
            ps.setString(4, register.getBirthday());
            ps.setString(5, register.getGender());
            ps.setString(6, register.getBloodGroup());
            ps.setString(7, register.getAddress());
            ps.setString(8, register.getContact());
            ps.setString(9, register.getEmail());
            ps.setString(10, register.getPassword());
            ps.executeUpdate();
            System.out.println("Insert successfull");
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void update(Register register) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Register getUserByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Register getUserByLastName(String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Register register) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Register> getList() {
        List<Register> list = new ArrayList<>();
        String sql = "select * from register";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Register register = new Register(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                list.add(register);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
