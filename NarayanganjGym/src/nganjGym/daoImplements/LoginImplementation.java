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
import java.util.logging.Level;
import java.util.logging.Logger;
import nganjGym.connection.DbConnection;
import nganjGym.dao.LoginDao;
import nganjGym.pojo.Register;

/**
 *
 * @author User
 */
public class LoginImplementation implements LoginDao {

    Connection connection = DbConnection.getDBConnection();

    @Override
    public Register findByEmailAndPassword(String email, String password) {
        Register register = null;
        String sql = "select * from register where email=? and password=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                register = new Register(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return register;
    }

}
