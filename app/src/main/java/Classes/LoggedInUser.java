package Classes;

public class LoggedInUser {

    private static LoggedInUser ourInstance = null;
    User user;

    public static LoggedInUser getInstance() {
        return ourInstance != null ? ourInstance : new LoggedInUser();
    }

    private LoggedInUser () {
        user = new User();//TODO  fix the right user to this??
//        this.user=user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}