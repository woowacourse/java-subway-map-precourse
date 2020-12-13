package subway.domain;

public class Order {
    private static final int STARTING_ORDER = 1;

    private final int order;

    public Order(int order) {
        if (order < 1) {
            throw new IllegalArgumentException("순서는 1이상의 숫자여야 합니다.");
        }

        this.order = order;
    }

    public int getValue() {
        return order;
    }

    public static int getStartingNumber() {
        return STARTING_ORDER;
    }

    public boolean isBiggerThan(int integer) {
        return order > integer;
    }
}
