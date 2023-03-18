package tevolvers.models;

public class Token {

    private String contentType;
    private String username;
    private String password;

    public Token(String contentType, String username, String password) {
        this.contentType = contentType;
        this.username = username;
        this.password = password;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "\"username\": \"" + username + "\"," +
                "\"password\": \"" + password + "\"" +
                '}';
    }
}
