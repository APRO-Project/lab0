package entities.users;

public class User {
    private String firstName;
    private String lastName;
    private UserType userType;

    public User(String firstName, String lastName, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getUserType() {
        return userType;
    }
}
