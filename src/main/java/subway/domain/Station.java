package subway.domain;

public class Station {
    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public boolean isLinePassed () {
        for (Line line : LineRepository.lines()){
            if (line.hasStation(this)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
