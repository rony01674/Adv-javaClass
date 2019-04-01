/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganjGym.daoImplements;

import java.sql.Connection;
import nganjGym.connection.DbConnection;
import nganjGym.dao.MyAccountDao;
import nganjGym.pojo.MyAccount;

/**
 *
 * @author Asaduzzaman Rony
 */
public class MyAccountImplementation implements MyAccountDao {

    Connection conn = DbConnection.getDBConnection();

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
        String sql = "create table IF NO EXISTS my_account(ins_id int (11) auto_increment"
                + " priamry key, full_name varchar (50) not null, user_name varchar (30)"
                + " unique, )";
    }

    @Override
    public void save(MyAccount myAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(MyAccount myAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MyAccount getUserByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MyAccount getUserByUserName(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
