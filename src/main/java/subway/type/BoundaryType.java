package subway.type;

public enum  BoundaryType {
    NAME_LENGTH_BOUNDARY(2);

    private final int boundary;

    BoundaryType(int boundary) {
        this.boundary = boundary;
    }

    public int getBoundary() {
        return boundary;
    }
}
