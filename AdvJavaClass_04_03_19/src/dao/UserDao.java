package dao;

import java.util.List;
import pojo.User;

public interface UserDao {

    void createTable();

    void save(User user);

    void update(User user);

    User getUserByID(int id);

    User getUserByUserName(String userName);

    void delete(int id);

    List<User> getUsers();
}
