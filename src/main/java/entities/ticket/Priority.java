package entities.ticket;

public enum Priority {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private final int value;


    private Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Priority getPriority(int value){
        return switch (value) {
            case 0 -> LOW;
            case 1 -> MEDIUM;
            case 2 -> HIGH;
            default -> null;
        };
    }
}
