package test;

import dao.RoleDao;
import service.RoleDaoImplement;

public class RoleTest {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDaoImplement();
        roleDao.createTable();
    }
}
