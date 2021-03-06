package evidence.pojo;

public class Student {

    private int id;
    private String name;
    private int age;
    private String email;
    private String gender;
    private String cc;
    private String round;
    private String msg;

    public Student() {
    }

    public Student(String name, int age, String email, String gender, String cc, String round, String msg) {
        
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.cc = cc;
        this.round = round;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getCc() {
        return cc;
    }

    public String getRound() {
        return round;
    }

    public String getMsg() {
        return msg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", gender=" + gender + ", cc=" + cc + ", round=" + round + ", msg=" + msg + '}';
    }

}
