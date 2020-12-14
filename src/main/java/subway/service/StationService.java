package subway.service;

import static subway.console.Output.print;

import java.util.Collections;
import java.util.List;
import subway.console.Message;
import subway.domain.Station;
import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class StationService {
    private static final int STATION_NAME_LENGTH = 2;
    private static final String STATION_END_NAME = "역";

    public boolean addStation(String name) {
        if (isValidate(name)) {
            StationRepository.addStation(new Station(name));
            return true;
        }
        return false;
    }

    private boolean isValidate(String name) {
        try {
            validateNameLength(name);
            validateNameEndWord(name);
            validateExistStation(name);
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
        return true;
    }

    private void validateNameLength(String name) {
        if (name.length() < STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_NAME_LENGTH);
        }
    }

    private void validateNameEndWord(String name) {
        if (!name.endsWith(STATION_END_NAME)) {
            throw new IllegalArgumentException(Message.ERROR_STATION_NAME_END);
        }
    }

    private void validateExistStation(String name) {
        if (StationRepository.isExist(name)) {
            throw new IllegalArgumentException(Message.ERROR_EXIST_STATION);
        }
    }

    public boolean deleteStation(String name) {
        try {
            StationRepository.deleteStation(name);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
        }
        print(Message.ERROR_NOT_EXIST_STATION);
        return false;
    }

    public List<Station> findAll() {
        if (StationRepository.stations().isEmpty()) {
            print(Message.ERROR_EMPTY_STATION);
            return Collections.emptyList();
        }
        return StationRepository.stations();
    }
}
