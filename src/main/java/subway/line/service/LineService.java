package subway.line.service;

import java.util.List;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.dto.LineRequestDto;
import subway.line.dto.LineResponseDto;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class LineService {

    public static List<LineResponseDto> findAll() {
        return LineResponseDto.of(LineRepository.findAll());
    }

    public static void save(LineRequestDto requestDto) {
        Station upstreamStation = StationRepository.findByName(requestDto.getUpstreamStationName());
        Station downstreamStation = StationRepository.findByName(requestDto.getDownstreamStationName());
        Line newLine = Line.of(requestDto.getName(), upstreamStation, downstreamStation);
        LineRepository.save(newLine);
    }

    public static void deleteByName(String name) {
        Line line = LineRepository.findByName(name);
        LineRepository.delete(line);
    }

    public static boolean contains(Station targetStation) {
        return LineRepository.findAll().stream()
            .anyMatch(line -> line.contains(targetStation));
    }
}
