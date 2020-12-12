package subway.station.service;

import java.util.List;
import subway.line.service.LineService;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.dto.StationRequestDto;
import subway.station.dto.StationResponseDto;
import subway.station.exception.CannotDeleteStationAlreadyAddedLineException;

public class StationService {

    public static List<StationResponseDto> findAll() {
        return StationResponseDto.of(StationRepository.findAll());
    }

    public static void save(StationRequestDto requestDto) {
        Station newStation = Station.from(requestDto.getName());
        StationRepository.save(newStation);
    }

    public static void deleteByName(String name) {
        Station station = StationRepository.findByName(name);
        if (LineService.contains(station)) {
            throw new CannotDeleteStationAlreadyAddedLineException(station.getName());
        }

        StationRepository.delete(station);
    }
}
