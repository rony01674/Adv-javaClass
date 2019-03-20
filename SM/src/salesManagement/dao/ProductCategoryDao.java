package salesManagement.dao;

import java.util.List;
import salesManagement.pojo.ProductCategory;

public interface ProductCategoryDao {

    void createTable();

    void save(ProductCategory pc);

    void update(ProductCategory pc);

    ProductCategory getProductCategoryById(int id);

    ProductCategory getProductCategoryBycategoryName(String catName);

    void delete(int id);

    List<ProductCategory> getList();
}
