package entities.users;

import entities.ticket.Status;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
    CUSTOMER(0),
    DISPATCHER(1),
    CONTRACTOR(2);

    private static Map<Integer, UserType> map = new HashMap<>();
    private final int value;

    static {
        for (UserType pageType : UserType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    UserType(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static UserType fromInt(int value) {
        return map.get(value);
    }
}
