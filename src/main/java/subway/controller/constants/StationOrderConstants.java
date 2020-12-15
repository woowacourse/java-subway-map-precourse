package subway.controller.constants;

public enum StationOrderConstants {
    INITIAL(1),
    TERMINAL(2);

    private int location;

    StationOrderConstants(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
