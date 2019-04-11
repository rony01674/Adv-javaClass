/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganjGym.dao;

import java.util.List;
import nganjGym.pojo.MembershipPlan;

/**
 *
 * @author User
 */
public interface MembershipPlanDao {

    void createTable();

    void save(MembershipPlan mp);

    void update(MembershipPlan mp);

    void delete(MembershipPlan mp);

    List<MembershipPlan> getList();
}
