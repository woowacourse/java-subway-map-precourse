package subway.service;


import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LineService {
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 이름의 노선이 존재합니다.";
    private static final String NON_EXISTENT_STATION_ERROR_MESSAGE = "해당 이름의 역이 존재하지 않습니다.";
    private static final String NON_EXISTENT_LINE_ERROR_MESSAGE = "해당 이름의 노선이 존재하지 않습니다.";
    private static final int INITIAL_UPWARD_END_STATION_INDEX = 0;
    private static final int INITIAL_DOWNWARD_END_STATION_INDEX = 1;

    public void addLine(Line line) {
        if (isExistent(line)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
        if (isNonExistentStation(line)) {
            throw new IllegalArgumentException(NON_EXISTENT_STATION_ERROR_MESSAGE);
        }
        LineRepository.addLine(line);
    }

    public boolean isExistent(Line line) {
        return LineRepository.isExistentName(line.getName());
    }

    private boolean isNonExistentStation(Line line) {
        List<Station> sections = line.getSections();
        Station upwardEndStation = sections.get(INITIAL_UPWARD_END_STATION_INDEX);
        Station downwardEndStation = sections.get(INITIAL_DOWNWARD_END_STATION_INDEX);
        return !StationRepository.isExistent(upwardEndStation) || !StationRepository.isExistent(downwardEndStation);
    }

    public boolean deleteLine(String lineName) {
        if (!LineRepository.deleteLineByName(lineName)) {
            throw new IllegalArgumentException(NON_EXISTENT_LINE_ERROR_MESSAGE);
        }
        return true;
    }

    public List<String> getLineNames() {
        return LineRepository.lines()
                .stream()
                .map(Line::getName)
                .collect(Collectors.toList());
    }
}
