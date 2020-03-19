package entities.ticket;

import java.util.HashMap;
import java.util.Map;

public enum Priority {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private static Map<Integer, Priority> map = new HashMap<>();
    private final int value;

    static {
        for (Priority pageType : Priority.values()) {
            map.put(pageType.value, pageType);
        }
    }

    Priority(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static Priority fromInt(int value) {
        return map.get(value);
    }
}
