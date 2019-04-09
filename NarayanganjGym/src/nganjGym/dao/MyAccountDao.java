package nganjGym.dao;

import java.util.List;
import nganjGym.pojo.Login;
import nganjGym.pojo.MyAccount;

/**
 *
 * @author Asaduzzaman Rony
 */
public interface MyAccountDao {

    void createTable();

    void save(MyAccount myAccount);

    void update(MyAccount myAccount);

    MyAccount getUserByID(String insID);

    void delete(String insID);

    List<MyAccount> getList();
}
