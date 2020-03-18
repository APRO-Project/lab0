package entities.ticket;

public enum Status {
    AWAITING(0),
    ASSIGNED(1),
    COMPLETED(2);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static Status getStatus(int value){
        return switch (value) {
            case 0 -> AWAITING;
            case 1 -> ASSIGNED;
            case 2 -> COMPLETED;
            default -> null;
        };
    }
}
