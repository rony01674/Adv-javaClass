package practice2;

public class Student {
    private int id;
    private String name;
    private String email;
    private int age;
    private String gender;
    private String courses;
    private String round;
    private String msg;

    public Student(int id, String name, String email, int age, String gender, String courses, String round, String msg) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.courses = courses;
        this.round = round;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCourses() {
        return courses;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
