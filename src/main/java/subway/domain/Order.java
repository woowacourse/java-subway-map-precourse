package subway.domain;

import subway.domain.validator.OrderValidator;

public class Order {
    private static final int STARTING_ORDER = 1;

    private final int order;

    public Order(int order) {
        OrderValidator.checkIsValidOrder(order, STARTING_ORDER);
        this.order = order;
    }

    public int getIndex() {
        return order - STARTING_ORDER;
    }
}
