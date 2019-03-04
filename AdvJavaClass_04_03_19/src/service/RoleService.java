package service;

import connection.DBConnection;
import dao.RoleDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import pojo.Role;

public class RoleService implements RoleDao {

    Connection connection = DBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS role(id int(2) auto_increment primary key, role_name varchar(20) not null unique)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            System.out.println("Table Created");
        } catch (Exception e) {
        }
    }

    @Override
    public void save(Role role) {
        String sql = "insert into role(role_name) values(?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            pstm.executeUpdate();
            System.out.println("Successfully Inserted");
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role getRoleByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> getRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
