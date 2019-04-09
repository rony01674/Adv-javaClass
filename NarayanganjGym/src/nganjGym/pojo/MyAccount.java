package nganjGym.pojo;

public class MyAccount {

    private String insID;
    private String fname;
    private String lname;
    private String birthday;
    private String gender;
    private String bloodGroup;
    private String address;
    private String contact;
    private String email;
    private String password;

    public MyAccount() {
    }

    public MyAccount(String insID, String fname, String lname, String birthday, String gender, String bloodGroup, String address, String contact, String email, String password) {
        this.insID = insID;
        this.fname = fname;
        this.lname = lname;
        this.birthday = birthday;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
    }

    public String getInsID() {
        return insID;
    }

    public void setInsID(String insID) {
        this.insID = insID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
