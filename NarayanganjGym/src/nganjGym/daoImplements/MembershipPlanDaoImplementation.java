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
import nganjGym.dao.MembershipPlanDao;
import nganjGym.pojo.MembershipPlan;

/**
 *
 * @author Asaduzzaman ROny
 */
public class MembershipPlanDaoImplementation implements MembershipPlanDao {

    public static void main(String[] args) {
        MembershipPlanDaoImplementation mpdi = new MembershipPlanDaoImplementation();
        mpdi.createTable();
    }

    Connection connection = DbConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS membership_plan(plan_id varchar(8) primary key, "
                + "plan_type varchar(20) not null, plan_duration varchar(30) not null, "
                + "membership_fee float(8,2))";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(MembershipPlanDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void save(MembershipPlan mp) {
        String sql = "insert into membership_plan(plan_id, plan_type, plan_duration, membership_fee) "
                + "values(?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mp.getPlanID());
            ps.setString(2, mp.getPlanType());
            ps.setString(3, mp.getPlanDuration());
            ps.setDouble(4, mp.getPlanFee());
            ps.executeUpdate();
            System.out.println("Insert Successfull");
        } catch (SQLException ex) {
            Logger.getLogger(MembershipPlanDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(MembershipPlan mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(MembershipPlan mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MembershipPlan> getList() {
        List<MembershipPlan> list = new ArrayList<>();
        String sql = "select * from membership_plan";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MembershipPlan mp = new MembershipPlan(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4));
                list.add(mp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembershipPlanDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
