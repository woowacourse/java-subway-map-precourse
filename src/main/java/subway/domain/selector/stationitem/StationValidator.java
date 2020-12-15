package subway.domain.selector.stationitem;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationValidator {

    public static final int MIN_NAME_LENGTH = 2;
    public static final String DUPLICATE_STATION_NAME_ERROR = "\n[ERROR] 이미 등록되어있는 역 입니다.";
    public static final String UNDER_NAME_LENGTH_ERROR = "[ERROR] 역 이름은 2글자 이상이어야 합니다.";
    public static final String CONTAINS_LINE_ERROR = "[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.";
    public static final String NOT_CONTAINS_ERROR = "[ERROR] 입력하신 역은 등록되지 않았습니다.";

    public void validateAddStation(String name) {
        validateNameDuplication(name);
        validateNameLength(name);
    }

    public void validateRemoveStation(String name) {
        validateContainsStations(name);
        validateContainsLines(name);
    }

    private void validateNameDuplication(String name) {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                throw new IllegalArgumentException(DUPLICATE_STATION_NAME_ERROR);
            }
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(UNDER_NAME_LENGTH_ERROR);
        }
    }

    private void validateContainsLines(String name) {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            validateContainsLine(line, name);
        }
    }

    private void validateContainsLine(Line line, String name) {
        List<Station> stations = line.stations();

        for (Station station : stations) {
            if (station.getName().equals(name)) {
                throw new IllegalArgumentException(CONTAINS_LINE_ERROR);
            }
        }
    }

    public void validateContainsStations(String name) {
        List<Station> stations = StationRepository.stations();

        for (Station station : stations) {
            if (name.equals(station.getName())) {
                return;
            }
        }
        throw new IllegalArgumentException(NOT_CONTAINS_ERROR);
    }

}
