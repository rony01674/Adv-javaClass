package salesManagement.dao;

import java.util.List;
import salesManagement.pojo.Summary;

public interface SummaryDao {

    void createTable();

    void save(Summary s);

    void update(Summary s);

    Summary getSummaryByProductCode(String code);

    List<Summary> getList();
}
