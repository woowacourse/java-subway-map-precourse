package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Section {

    private static final int MINIMUM_RANGE = 0;
    private static final int COVER_INDEX = 1;

    private final Line line;
    private final List<Station> stations;

    private Section(Line line, List<Station> stations) {
        this.line = line;
        this.stations = stations;
    }

    public static Section newSectionWithLine(Line newLine) {
        return new Section(newLine, new ArrayList<>());
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStationWithPosition(Station station, String position) {
        validateStationDuplicate(station);
        int integerPosition = validatePositionInteger(position)-COVER_INDEX;
        validatePositionRange(integerPosition);
        stations.add(integerPosition, station);
    }

    public void deleteStationByName(String stationName) {
        if (!stations.removeIf(station -> Objects.equals(station.getName(), stationName))) {
            throw new IllegalArgumentException("현재 노선에 해당 지하철 역이 존재하지 않습니다.");
        }
    }

    private void validateStationDuplicate(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 노선에 등록되어 있거나, 등록 진행 중인 지하철 역 입니다.");
        }
    }

    private int validatePositionInteger(String position) {
        try {
            return Integer.parseInt(position);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("순서 값은 정수어야만 합니다.");
        }
    }

    private void validatePositionRange(int integerPosition) {
        if (integerPosition < MINIMUM_RANGE || stations.size() < integerPosition) {
            throw new IllegalArgumentException("입력 가능한 순서 범위를 벗어났습니다.");
        }
    }
}
