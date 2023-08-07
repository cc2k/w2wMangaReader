package Classes;

public class User {

    private String username;
    private String password;
    private int userId;
    private int collectionId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public User (){}

    public User(String username, String password, int userId, int collectionId) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.collectionId = collectionId;
    }
}
