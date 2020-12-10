package subway.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.station.StationRepository;

import java.util.List;
import java.util.stream.Collectors;

import static subway.line.LineValidator.*;

public class LineController {
    private static final String ALREADY_EXISTS = "중복된 이름입니다.";
    private static final String WRONG_STATION = "역을 먼저 등록해주세요.";
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

    public List<LineResponseDTO> findLines(){
        List<Line> lines = lineRepository.lines();
        return lines.stream()
                .map(LineResponseDTO::new)
                .collect(Collectors.toList());
    }

    private void checkDuplicateName(String name) {
        if(lineRepository.findByName(name).isPresent()){
            throw new IllegalStateException(ALREADY_EXISTS);
        }
    }

    private Station getStationByName(String name) {
        return stationRepository.findStationByName(name)
                .orElseThrow(() -> new IllegalStateException(WRONG_STATION));
    }
}
