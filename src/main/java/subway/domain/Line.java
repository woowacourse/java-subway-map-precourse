package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Line {
    private final String name;
    private final List<Station> stations = new ArrayList<>();
    static final int ORDER_SUBTRACT_INDEX = 1;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStation(Station station) {
        if (getStation().contains(station)) {
            return;
        }
        if (StationRepository.stations().contains(station)) {
            stations.add(station);
        }
    }

    public List<Station> getStation() {
        return stations;
    }

    public void addOrderedStation(Station station, int order) {
        int orderIndex = order - ORDER_SUBTRACT_INDEX;
        if (StationRepository.stations().contains(station)) {
            stations.add(orderIndex, station);
        }
    }

    public void removeOrderedStation(Station station) {
        for (Line line : LineRepository.fixedLines()) {
            if (line.getName().equals(getName()) && line.getStation().contains(station)) {
                ErrorMessage.isNotAbleToDeleteStation();
                return;
            }
        }
        Optional<Station> searchedLine = getStation().stream()
                .filter(station1 -> station1.equals(station)).findAny();
        if (StationRepository.stations().contains(station)) {
            stations.removeIf(station1 -> Objects.equals(station1.getName(), station.getName()));
        }
    }
}
