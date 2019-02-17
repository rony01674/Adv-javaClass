package evidence.service;

import evidence.connection.DbConnection;
import evidence.pojo.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService implements CommonDAO {

    static Connection connection = DbConnection.getDBconnection();

    @Override
    public void save(Student obj) {
        String sql = "insert into student(name, age, email, gender, complete_course, round, message) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getAge());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getGender());
            ps.setString(5, obj.getCc());
            ps.setString(6, obj.getRound());
            ps.setString(7, obj.getMsg());
            ps.executeUpdate();
            System.out.println("Data successfully inserted into Student table");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Student obj) {
        String sql = "update student set name=?, age=?, email=?, gender=?, complete_course=?, round=?, message=? where id=?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getAge());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getGender());
            ps.setString(5, obj.getCc());
            ps.setString(6, obj.getRound());
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void delete(Student obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByID(Student obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
