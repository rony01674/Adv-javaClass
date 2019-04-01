/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nganjGym.dao;

import nganjGym.pojo.Register;

/**
 *
 * @author User
 */
public interface LoginDao {

    Register findByEmailAndPassword(String email, String password);
}
