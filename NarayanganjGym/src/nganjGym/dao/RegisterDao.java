/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganjGym.dao;

import nganjGym.pojo.Register;

/**
 *
 * @author Asaduzzaman Rony
 */
public interface RegisterDao {

    void createTable();

    void save(Register register);

    void update(Register register);

    Register getUserByID(int id);

    Register getUserByLastName(String lname);

    void delete(Register register);
}
