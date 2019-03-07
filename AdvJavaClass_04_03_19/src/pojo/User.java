package pojo;

public class User {
    private int id;
    private String fullName;
    private String userName;
    private String password;
    private String mobile;
    private Role role;

    public User() {
    }

    public User(String fullName, String userName, String password, String mobile, Role role) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.role = role;
    }

    public User(int id, String fullName, String userName, String password, String mobile, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public Role getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullName=" + fullName + ", userName=" + userName + ", password=" + password + ", mobile=" + mobile + ", role=" + role + '}';
    }
    
    
}
