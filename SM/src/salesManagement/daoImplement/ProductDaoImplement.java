package salesManagement.daoImplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import salesManagement.connection.DBConnection;
import salesManagement.dao.ProductDao;
import salesManagement.pojo.Product;
import salesManagement.pojo.ProductCategory;

public class ProductDaoImplement implements ProductDao {

    public static void main(String[] args) {
//        ProductDaoImplement pdi = new ProductDaoImplement();
//        pdi.createTable();
    }

    Connection conn = DBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS product(id int(11) auto_increment"
                + " primary key, product_name varchar(50),product_code varchar(30),"
                + "qty int(11),unit_price double,total_price double, purchase_date date,"
                + " p_cat_id int(5),FOREIGN KEY (p_cat_id) REFERENCES product_category(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void save(Product p) {
        String sql = "insert into product(product_name,product_code,qty,unit_price,"
                + "total_price,purchase_date,p_cat_id) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getProductCode());
            ps.setInt(3, p.getQty());
            ps.setDouble(4, p.getUnitPrice());
            ps.setDouble(5, p.getTotalPrice());
            ps.setDate(6, (Date) p.getDate());
            ps.setInt(7, p.getProductCategory().getId());
            ps.executeUpdate();
            System.out.println("Insert Successful");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProductById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProductByProductCode(String code) {
        Product product = null;
        String sql = "select * from produc where product_code=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7),
                        new ProductCategory(rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getList() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getDouble(5), rs.getInt(6), rs.getDate(7),
                        new ProductCategory(rs.getInt(8)));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
