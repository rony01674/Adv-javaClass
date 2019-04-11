package nganjGym.pojo;

public class MembersManagement {
    private String membersID;
    private String fname;
    private String lname;
    private String birthday;
    private String gender;
    private String bloodGroup;
    private String hCondition;
    private String address;
    private String contact;
    private String email;

    public MembersManagement() {
    }

    public MembersManagement(String membersID, String fname, String lname, String birthday, String gender, String bloodGroup, String hCondition, String address, String contact, String email) {
        this.membersID = membersID;
        this.fname = fname;
        this.lname = lname;
        this.birthday = birthday;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.hCondition = hCondition;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public String getMembersID() {
        return membersID;
    }

    public void setMembersID(String membersID) {
        this.membersID = membersID;
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

    public String gethCondition() {
        return hCondition;
    }

    public void sethCondition(String hCondition) {
        this.hCondition = hCondition;
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
