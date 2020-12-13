package subway.domain;

import java.util.ArrayList;
import java.util.List;

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

    private void validateStationDuplicate(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 현재 노선에 등록 되어 있는 지하철 역 입니다.");
        }
    }

    private int validatePositionInteger(String position) {
        try {
            return Integer.parseInt(position);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 순서 값이 아닙니다.");
        }
    }

    private void validatePositionRange(int integerPosition) {
        if (integerPosition < MINIMUM_RANGE || stations.size() < integerPosition) {
            throw new IllegalArgumentException("입력 가능한 순서 범위를 벗어났습니다.");
        }
    }
}
