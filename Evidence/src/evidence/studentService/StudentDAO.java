package evidence.studentService;

import evidence.student.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student obj);

    void update(Student obj);

    void delete(Student obj);

    void deleteByID(Student obj);

    Student getByID(int id);

    List<Student> findAll();
}
