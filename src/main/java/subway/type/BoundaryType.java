package subway.type;

public enum BoundaryType {
    NAME_LENGTH_BOUNDARY(2),
    ORDER_NUMBER_BOUNDARY(1),
    ORDER_REPLACEMENT_LENGTH_BOUNDARY(0);

    private final int boundary;

    BoundaryType(int boundary) {
        this.boundary = boundary;
    }

    public int getBoundary() {
        return boundary;
    }
}
