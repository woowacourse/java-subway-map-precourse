package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.NameLengthException;
import subway.exception.StationNameDuplicateException;
import subway.exception.StationNameNotFoundException;
import java.util.List;

public class StationService {
    private static final int MIN_NAME_LENGTH = 2;

    public static void save(Station station) {
        validateNameLength(station.getName());
        validateDuplicateName(station.getName());
        StationRepository.addStation(station);
    }

    public static void remove(String name) {
        validateNameLength(name);
        StationRepository.deleteStation(
                StationRepository.findByName(name)
                        .orElseThrow(StationNameNotFoundException::new).getName());
    }

    private static void validateNameLength(String name) {
        if(name.length() < MIN_NAME_LENGTH) {
            throw new NameLengthException();
        }
    }

    private static void validateDuplicateName(String name) {
        if(StationRepository.findByName(name).isPresent()) {
            throw new StationNameDuplicateException();
        }
    }

    public static List<Station> getAllStations() {
        return StationRepository.stations();
    }
}
