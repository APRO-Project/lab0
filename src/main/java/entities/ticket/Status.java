package entities.ticket;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    AWAITING(0),
    ASSIGNED(1),
    COMPLETED(2);

    private static Map<Integer, Status> map = new HashMap<>();
    private final int value;

    static {
        for (Status pageType : Status.values()) {
            map.put(pageType.value, pageType);
        }
    }

    Status(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static Status fromInt(int value) {
        return map.get(value);
    }
}
