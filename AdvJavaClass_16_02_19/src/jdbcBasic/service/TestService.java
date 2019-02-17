package jdbcBasic.service;

import jdbcBasic.pojo.Student;

public class TestService {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Rony");
        
        
        CommonDAO commonDAO = new StudentService();
        commonDAO.save(s1);
    }
}
