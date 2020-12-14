package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.NameLengthException;
import subway.exception.StationNameDuplicateException;

public class StationService {
    private static final int MIN_NAME_LENGTH = 2;

    public static void save(Station station) {
        validateNameLength(station.getName());
        validateDuplicateName(station.getName());
        StationRepository.addStation(station);
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
}
