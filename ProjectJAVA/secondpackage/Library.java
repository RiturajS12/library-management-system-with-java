package secondpackage;

public class Library {
    private String username;
    private String password;

    public Library(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
