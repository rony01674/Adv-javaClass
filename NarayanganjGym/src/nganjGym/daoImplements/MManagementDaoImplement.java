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
import nganjGym.dao.MembersManagementDao;
import nganjGym.pojo.MembersManagement;

public class MManagementDaoImplement implements MembersManagementDao {

    public static void main(String[] args) {
        MManagementDaoImplement mmdi = new MManagementDaoImplement();
        mmdi.createTable();
    }

    Connection connection = DbConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS members_management(members_id varchar(10) primary key,"
                + "first_name varchar(30), last_name varchar(20), birthday varchar(20),"
                + "gender varchar(8),blood_group varchar(5), health_condition varchar(50), "
                + "address varchar(50), contact varchar(14) unique, email varchar(30) unique)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(MManagementDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(MembersManagement mm) {
        String sql = "insert into members_management(members_id, first_name, last_name, "
                + "birthday, gender, blood_group, health_condition, address, contact, "
                + "email) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mm.getMembersID());
            ps.setString(2, mm.getFname());
            ps.setString(3, mm.getLname());
            ps.setString(4, mm.getBirthday());
            ps.setString(5, mm.getGender());
            ps.setString(6, mm.getBloodGroup());
            ps.setString(7, mm.gethCondition());
            ps.setString(8, mm.getAddress());
            ps.setString(9, mm.getContact());
            ps.setString(10, mm.getEmail());
            ps.executeUpdate();
            System.out.println("Insert Successfull!");
        } catch (SQLException ex) {
            Logger.getLogger(MManagementDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(MembersManagement mm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(MembersManagement mm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MembersManagement getByMemberId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MembersManagement getByMemberName(String fname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MembersManagement> getList() {
        List<MembersManagement> list = new ArrayList<>();
        String sql = "select * from members_management";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MembersManagement mm = new MembersManagement(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                list.add(mm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MManagementDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
