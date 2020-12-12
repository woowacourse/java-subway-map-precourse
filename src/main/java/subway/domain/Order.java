package subway.domain;

public class Order {
    private static final int MIN_ORDER = 2;
    private int order;
    private Line line;

    public Order(String order, Line line) {
        try {
            this.order = Integer.parseInt(order);
            this.line = line;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
        validateOrder();
    }

    private void validateOrder() {
        int maxOrder = line.getStations().size();
        if (this.order < MIN_ORDER || this.order > maxOrder) {
            throw new IllegalArgumentException("[ERROR] 적절한 범위의 순서만 입력하셔야 합니다.");
        }
    }

    public int getOrder() {
        return this.order;
    }
}
