package nganjGym.dao;

import java.util.List;
import nganjGym.pojo.MembersManagement;

public interface MembersManagementDao {

    void createTable();

    void save(MembersManagement mm);

    void update(MembersManagement mm);

    void delete(MembersManagement mm);

    MembersManagement getByMemberId(String id);

    MembersManagement getByMemberName(String fname);

    List<MembersManagement> getList();
}
