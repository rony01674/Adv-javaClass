package evidence.service;

import evidence.pojo.Student;
import java.util.List;

public interface CommonDAO {

    void save(Student obj);

    void update(Student obj);

    void delete(Student obj);

    void deleteByID(Student obj);

    Student getByID(int id);

    List<Student> findAll();
}
