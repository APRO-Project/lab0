package entities.users;

public class User {
    private String firstName;
    private String lastName;
    private long ID;
    private String userName;
    private UserType userType;

    public User(String firstName, String lastName, long ID, String userName, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.userName = userName;
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public UserType getUserType() {
        return userType;
    }
}
