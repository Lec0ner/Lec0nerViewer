package sample;

public class User {
    private String login;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.login = username;
        this.email = email;
        this.password = password;
    }

    public User(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
