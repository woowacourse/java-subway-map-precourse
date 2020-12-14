package subway.controller.constants;

public enum StationOrderConstants {
    INITIAL(0),
    TERMINAL(1);

    private int location;

    StationOrderConstants(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }
}
