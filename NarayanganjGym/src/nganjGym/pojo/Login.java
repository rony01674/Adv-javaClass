package nganjGym.pojo;

/**
 *
 * @author Asaduzzaman Rony
 */
public class Login {

    private String insID;
    private String password;

    public Login() {
    }

    public Login(String insID, String password) {
        this.insID = insID;
        this.password = password;
    }

    public String getEmail() {
        return insID;
    }

    public void setEmail(String insID) {
        this.insID = insID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
