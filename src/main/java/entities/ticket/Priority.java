package entities.ticket;

public enum Priority {
    LOW(0),
    MEDIUM(1),
    HIGH(2);


    private final int value;

    Priority(int i) {
        this.value = i;
    }

    public Integer getValue() {
        return value;
    }
}
