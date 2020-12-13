package subway.service;

import subway.domain.entity.Sections;
import subway.domain.entity.Station;
import subway.domain.repository.StationRepository;
import subway.dto.LineDto;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void addStationByName(String name) {
        stationRepository.findByName(name)
                .ifPresent(station -> {
                    throw new StationDuplicationException();
                });
        Station station = new Station(name);
        stationRepository.save(station);
    }

    public boolean deleteStationByName(String name) {
        Station station = findStationByName(name);
        if (station.isRegisteredAsLineSection()) {
            throw new CannotDeleteStationException();
        }
        return stationRepository.delete(station);
    }

    public Station findStationByName(String name) {
        return stationRepository.findByName(name)
                .orElseThrow(CannotFindStationException::new);
    }

    public Sections createSections(LineDto lineDto) {
        Station upwardLastStation = findStationByName(lineDto.getUpwardLastStationName());
        Station downwardLastStation = findStationByName(lineDto.getDownwardLastStationName());
        return Sections.of(upwardLastStation, downwardLastStation);
    }

    public List<String> getStationNames() {
        return stationRepository.findAll()
                .stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}
