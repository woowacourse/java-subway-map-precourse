package subway.domain.line.model;

import subway.domain.station.model.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String NAME_SHORTER_THAN_MIN_LINE_NAME_LIMIT_MESSAGE = "[ERROR] 지하철 노선 이름이 2글자 이상이어야 합니다.";
    private static final int MIN_LINE_NAME_LIMIT = 2;
    private static final int INITIAL_STATIONS_SIZE_NUMBER = 2;
    private static final String INITIAL_STATIONS_SIZE_ERROR_MESSAGE = "[ERROR] 노선의 초기 역 갯수는 2개여야 합니다.";

    private final String name;
    private final List<Station> stations;

    public Line(String name, List<Station> stations) {
        validateLine(name, stations);
        this.name = name;
        this.stations = new ArrayList<>(stations);
    }

    private void validateLine(String name, List<Station> stations) {
        validateLineNameLength(name);
        validateStationsSize(stations);
    }

    private void validateStationsSize(List<Station> stations) {
        if (stations.size() != INITIAL_STATIONS_SIZE_NUMBER) {
            throw new IllegalArgumentException(INITIAL_STATIONS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateLineNameLength(String name) {
        if (name.length() < MIN_LINE_NAME_LIMIT) {
            throw new IllegalArgumentException(NAME_SHORTER_THAN_MIN_LINE_NAME_LIMIT_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isEqualTo(Line line) {
        return Objects.equals(name, line.name);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}
