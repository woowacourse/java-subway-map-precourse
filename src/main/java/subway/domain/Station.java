package subway.domain;

public class Station {
    private String name;
    private Line line = null; //역은 line 정보를 가진다.

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isStationHasLine() {
        return line == null;
    }

    public boolean isNameMoreThan2Letters() {
        return name.length() >= 2;
    }
}
