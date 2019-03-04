package test;

import dao.RoleDao;
import service.RoleService;

public class RoleTest {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleService();
        roleDao.createTable();
    }
}
