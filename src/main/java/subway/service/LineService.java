package subway.service;


import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.dto.LineDto;

import java.util.List;
import java.util.stream.Collectors;

public class LineService {
    private static final String SAME_END_STATION_ERROR_MESSAGE = "상행 종점역과 하행 종점역은 같을 수 없습니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "이미 해당 이름의 노선이 존재합니다.";
    private static final String NON_EXISTENT_STATION_ERROR_MESSAGE = "해당 이름의 역이 존재하지 않습니다.";
    private static final String NON_EXISTENT_LINE_ERROR_MESSAGE = "해당 이름의 노선이 존재하지 않습니다.";

    public void addLine(LineDto lineDto) {
        if (isSameEndStationName(lineDto)) {
            throw new IllegalArgumentException(SAME_END_STATION_ERROR_MESSAGE);
        }
        if (isExistent(lineDto.getName())) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
        if (isNonExistentStation(lineDto)) {
            throw new IllegalArgumentException(NON_EXISTENT_STATION_ERROR_MESSAGE);
        }

        Station upwardEndStation = StationRepository.selectStation(lineDto.getUpwardEndStationName());
        Station downwardEndStation = StationRepository.selectStation(lineDto.getDownwardEndStationName());
        Line line = Line.createLine(lineDto.getName(), upwardEndStation, downwardEndStation);
        LineRepository.addLine(line);
    }

    private boolean isSameEndStationName(LineDto lineDto) {
        String upwardEndStation = lineDto.getUpwardEndStationName();
        String downwardEndStation = lineDto.getDownwardEndStationName();
        return upwardEndStation.equals(downwardEndStation);
    }

    public boolean isExistent(String lineName) {
        return LineRepository.isExistentName(lineName);
    }

    private boolean isNonExistentStation(LineDto lineDto) {
        String upwardEndStation = lineDto.getUpwardEndStationName();
        String downwardEndStation = lineDto.getDownwardEndStationName();

        return !StationRepository.isExistentName(upwardEndStation)
                || !StationRepository.isExistentName(downwardEndStation);
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
