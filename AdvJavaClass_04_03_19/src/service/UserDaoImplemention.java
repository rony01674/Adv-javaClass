package service;

import connection.DBConnection;
import dao.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Role;
import pojo.User;

public class UserDaoImplemention implements UserDao {

    public static void main(String[] args) {
        UserDaoImplemention obj = new UserDaoImplemention();
        obj.createTable();
    }

    Connection connection = DBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS user(id int(2) auto_increment primary key,"
                + " full_name varchar(50), user_name varchar(30) unique, password varchar(30),"
                + " mobile_no varchar(14) unique, role_id int(2), FOREIGN KEY (role_id)"
                + " REFERENCES role(id))";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImplemention.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(User user) {
        String sql = "insert into user(full_name, user_name, password, mobile_no, role_id) values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getFullName());
            pstm.setString(2, user.getUserName());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getMobile());
            pstm.setInt(5, user.getRole().getId());
            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImplemention.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set user_name=? where id=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getFullName());
            pstm.setInt(2, user.getId());
            pstm.executeUpdate();
            System.out.println("Update success!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User getUserByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = new User();
        String sql = "select * from user where user_name=?";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setFullName(rs.getString(2));
                user.setUserName(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setMobile(rs.getString(5));
                user.setRole(new Role(rs.getInt(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImplemention.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
