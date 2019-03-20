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
import salesManagement.dao.ProductSalesDao;
import salesManagement.pojo.Product;
import salesManagement.pojo.ProductSales;

public class ProductSalesDaoImplement implements ProductSalesDao {

    public static void main(String[] args) {
//        ProductSalesDaoImplement psdi = new ProductSalesDaoImplement();
//        psdi.createTable();
    }

    Connection conn = DBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS sales(id int(11) auto_increment"
                + " primary key, product_name varchar(50),product_code varchar(30),."
                + "qty int(11),unit_price double,total_price double, sales_date date,"
                + " p_id int(11),FOREIGN KEY (p_id) REFERENCES product(id))";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(ProductSalesDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void save(ProductSales ps) {
        String sql = "insert into sales(product_name,product_code,qty,unit_price,"
                + "total_price,sales_date,p_id) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, ps.getProductName());
            pstm.setString(2, ps.getProductCode());
            pstm.setInt(3, ps.getQty());
            pstm.setDouble(4, ps.getUnitPrice());
            pstm.setDouble(5, ps.getTotalPrice());
            pstm.setDate(6, (Date) ps.getSalesDate());
            pstm.setInt(7, ps.getProduct().getId());
            pstm.executeUpdate();
            System.out.println("Insert Successful");
        } catch (SQLException ex) {
            Logger.getLogger(ProductSalesDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ProductSales getProductSalesById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductSales getProductSalesByProductCode(String code) {
        ProductSales productSales = null;
        String sql = "select * from sales where id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productSales = new ProductSales(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7), new Product(rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductSalesDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productSales;
    }

    @Override
    public List<ProductSales> getList() {
        List<ProductSales> list = new ArrayList<>();
        String sql = "select * from sales";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductSales productSales = new ProductSales(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),
                        rs.getDouble(6), rs.getDate(7), new Product(rs.getInt(8)));
                list.add(productSales);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductSalesDaoImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
