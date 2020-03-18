package entities.users;

public class User {
    private String firstName;
    private String lastName;
    private long ID;
    private String userName;
    private USER_TYPE userType;

    public User(String firstName, String lastName, long ID, String userName, USER_TYPE userType) {
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

    public USER_TYPE getUserType() {
        return userType;
    }


}
