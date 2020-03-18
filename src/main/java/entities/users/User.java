package entities.users;

public class User {
    private String firstName;
    private String lastName;
    private long id;
    private String userName;
    private UserType userType;

    public User(String firstName, String lastName, long id, String userName, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.userName = userName;
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public UserType getUserType() {
        return userType;
    }
}
