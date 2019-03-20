package dao;

import pojo.Role;
import pojo.User;

public interface LoginDAO {

    User findByUsernameAndPassword(String username, String password, Role role);
}
