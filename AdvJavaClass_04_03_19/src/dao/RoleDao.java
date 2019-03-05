package dao;

import java.util.List;
import pojo.Role;

public interface RoleDao {
    
    void createTable(String sql);

    void save(Role role);

    void update(Role role);

    Role getRoleByID(int id);

    Role getRoleByRoleName(String roleName);

    void delete(int id);

    List<Role> getRoles();
}
