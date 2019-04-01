package nganjGym.pojo;

import java.util.Date;

public class MyAccount {

    private int insID;
    private String fname;
    private String userName;
    private Date birthday;
    private String gender;
    private String bloodGroup;
    private String address;
    private String contact;
    private String email;

    public MyAccount() {
    }

    public MyAccount(String fname, String userName, Date birthday, String gender, String bloodGroup, String address, String contact, String email) {
        this.fname = fname;
        this.userName = userName;
        this.birthday = birthday;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public MyAccount(int insID, String fname, String userName, Date birthday, String gender, String bloodGroup, String address, String contact, String email) {
        this.insID = insID;
        this.fname = fname;
        this.userName = userName;
        this.birthday = birthday;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public int getInsID() {
        return insID;
    }

    public void setInsID(int insID) {
        this.insID = insID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return userName;
    }

    public void setLname(String lname) {
        this.userName = lname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

}
