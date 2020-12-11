package subway.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.station.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

import static subway.line.LineErrorMessage.*;
import static subway.line.LineValidator.*;

public class LineController {
    private LineRepository lineRepository;
    private StationRepository stationRepository;

    public LineController(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void createLine(LineRequestDTO lineRequestDTO) {
        validateLineRequestDTO(lineRequestDTO);
        checkDuplicateName(lineRequestDTO.getName());
        Station start = getStationByName(lineRequestDTO.getStartStation());
        Station end = getStationByName(lineRequestDTO.getEndStation());
        lineRepository.addLine(Line.of(lineRequestDTO.getName(), start, end));
    }

    public List<LineResponseDTO> findLines() {
        List<Line> lines = lineRepository.lines();
        return lines.stream()
                .map(LineResponseDTO::new)
                .collect(Collectors.toList());
    }

    public LineResponseDTO findLineByName(String name) {
        Line line = getLineByName(name);
        return new LineResponseDTO(line);
    }

    public void addStationOnLine(String stationName, String lineName, int index) {
        Station station = getStationByName(stationName);
        Line line = getLineByName(lineName);
        if (!line.isCorrectIndex(index)) {
            throw new IllegalStateException(String.format(INVALID_INDEX.getMessage(), line.stationSize()));
        }
        line.joinStation(station, index);
    }

    public void removeStationFromLine(String stationName, String lineName) {
        Station station = getStationByName(stationName);
        Line line = getLineByName(lineName);
        if (!line.isStationRemovable()) {
            throw new IllegalStateException(UN_REMOVABLE.getMessage());
        }
        if (!line.containsStation(station)) {
            throw new IllegalStateException(NOT_FOUND_STATION.getMessage());
        }
        line.removeStation(station);
    }

    public void removeLine(String lineName) {
        Line line = getLineByName(lineName);
        line.removeAllStation();
        lineRepository.deleteLine(line);
    }


    private void checkDuplicateName(String name) {
        if (lineRepository.findByName(name).isPresent()) {
            throw new IllegalStateException(ALREADY_EXISTS.getMessage());
        }
    }

    private Station getStationByName(String name) {
        return stationRepository.findStationByName(name)
                .orElseThrow(() -> new IllegalStateException(WRONG_STATION.getMessage()));
    }

    private Line getLineByName(String name) {
        return lineRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_LINE.getMessage()));
    }

}
