package nganjGym.dao;

import nganjGym.pojo.MyAccount;

/**
 *
 * @author Asaduzzaman Rony
 */
public interface MyAccountDao {

    void createTable();

    void save(MyAccount myAccount);

    void update(MyAccount myAccount);

    MyAccount getUserByID(int id);

    MyAccount getUserByUserName(String userName);

    void delete(int id);
}
