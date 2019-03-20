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
import salesManagement.dao.ProductCategoryDao;
import salesManagement.pojo.ProductCategory;

public class PCatDaoImplement implements ProductCategoryDao {

    public static void main(String[] args) {
//        PCDaoImplement pcdao = new PCDaoImplement();
//        pcdao.createTable();
    }

    Connection conn = DBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS product_category(id int(5) "
                + "auto_increment primary key, cat_name varchar(20) unique)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(PCatDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(ProductCategory pc) {
        String sql = "insert into product_category(cat_name) values(?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pc.getCatName());
            ps.executeUpdate();
            System.out.println("Insert Successful!");
        } catch (SQLException ex) {
            Logger.getLogger(PCatDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ProductCategory pc) {
    }

    @Override
    public ProductCategory getProductCategoryById(int id) {
        ProductCategory pc = new ProductCategory();
        String sql = "select * from product_category where id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pc.setId(rs.getInt(1));
                pc.setCatName(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PCatDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }

    @Override
    public ProductCategory getProductCategoryBycategoryName(String catName) {
        ProductCategory pc = new ProductCategory();
        String sql = "select * from product_category where cat_name=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, catName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pc.setId(rs.getInt(1));
                pc.setCatName(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PCatDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductCategory> getList() {
        List<ProductCategory> list = new ArrayList<>();
        String sql = "select * from product_category";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductCategory pc = new ProductCategory(rs.getInt(1), rs.getString(2));
                list.add(pc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PCatDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
