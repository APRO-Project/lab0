package entities.users;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private UserType userType;

    public User(long id, String firstName, String lastName, String username, UserType userType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public UserType getUserType() {
        return userType;
    }

    @NotNull
    @Contract("_, _ -> new")
    public static User fromSqlResult(@NotNull ResultSet result, @Nullable String prefix) throws SQLException {
        String _prefix = prefix == null ? "" : prefix + ".";

        return new User(
                result.getLong(_prefix + "id"),
                result.getString(_prefix + "first_name"),
                result.getString(_prefix + "last_name"),
                result.getString(_prefix + "username"),
                UserType.fromInt(result.getInt(_prefix + "user_type"))
        );
    }
}
