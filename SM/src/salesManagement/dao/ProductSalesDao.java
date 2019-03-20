package salesManagement.dao;

import java.util.List;
import salesManagement.pojo.ProductSales;

public interface ProductSalesDao {

    void createTable();

    void save(ProductSales ps);

    ProductSales getProductSalesById(int id);

    ProductSales getProductSalesByProductCode(String code);

    List<ProductSales> getList();
}
