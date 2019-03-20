package salesManagement.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import salesManagement.connection.DBConnection;
import salesManagement.dao.SummaryDao;
import salesManagement.pojo.Product;
import salesManagement.pojo.Summary;

public class SummaryDaoImplement implements SummaryDao {

    Connection conn = DBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS summary(id int(11) auto_increment "
                + "primary key, product_name varchar(50),product_code varchar(30) "
                + "unique,total_qty int(11),sold_qty int(11),available_qty int(11),"
                + "  p_id int(11),FOREIGN KEY (p_id) REFERENCES product(id))";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(Summary s) {
        String sql = "insert into summary(product_name,product_code,total_qty,"
                + "sold_qty,available_qty,p_id) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getProductName());
            ps.setString(2, s.getProductCode());
            ps.setInt(3, s.getTotalQty());
            ps.setInt(4, s.getSoldQty());
            ps.setInt(5, s.getAvailableQty());
            ps.setInt(6, s.getProduct().getId());
            ps.executeUpdate();
            System.out.println("Insert Successful");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Summary s) {
        String sql = "update summary set total_qty=?,sold_qty=?,available_qty=? "
                + "where product_code=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getTotalQty());
            ps.setInt(2, s.getSoldQty());
            ps.setInt(3, s.getAvailableQty());
            ps.setString(4, s.getProductCode());
            ps.executeUpdate();
            System.out.println("Update Successful");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Summary getSummaryByProductCode(String code) {
        Summary summary = null;
        String sql = "select * from summary where product_code=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                summary = new Summary(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getInt(6), new Product(rs.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return summary;
    }

    @Override
    public List<Summary> getList() {
        List<Summary> list = new ArrayList<>();
        String sql = "select * from summary";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Summary summary = new Summary(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getInt(6), new Product(rs.getInt(7)));
                list.add(summary);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
