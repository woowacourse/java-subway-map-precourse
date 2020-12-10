package subway.line;

public class Line {
    private String name;
    private EachLineStations stations;

    public Line(String name, EachLineStations stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }
}
