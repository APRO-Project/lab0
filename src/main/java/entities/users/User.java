package entities.users;

/**
 * Class holding User data.
 */
public class User {
    private final String firstName;
    private final String lastName;
    private final UserType userType;

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
