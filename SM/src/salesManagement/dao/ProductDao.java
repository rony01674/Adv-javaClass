package salesManagement.dao;

import java.util.List;
import salesManagement.pojo.Product;

public interface ProductDao {

    void createTable();

    void save(Product p);

    void update(Product p);

    Product getProductById(int id);

    Product getProductByProductCode(String code);

    void delete(int id);

    List<Product> getList();

}
