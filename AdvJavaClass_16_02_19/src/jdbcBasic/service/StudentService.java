package jdbcBasic.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbcBasic.DataBaseConnection;
import jdbcBasic.pojo.Student;

public class StudentService implements CommonDAO {

    static Connection connection = DataBaseConnection.getDBconnection();

    @Override
    public void save(Student obj) {
        String sql = "insert into student(name) values(?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.executeUpdate();
            System.out.println("Data inserted successfully");
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student obj) {
        String sql = "Update student set name=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());
            ps.executeUpdate();
            System.out.println("Update Successfully");;
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Student obj) {
        
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from student where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);            
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Delete Successfully");;
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Student getById(int id) {
        String sql = "select * from student where id=?";
        Student student = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;

    }

    @Override
    public List<Student> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
