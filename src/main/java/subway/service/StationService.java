package subway.service;

import static subway.console.Output.print;

import java.util.Collections;
import java.util.List;
import subway.console.message.ErrorMessage;
import subway.domain.Station;
import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class StationService {

    public boolean addStation(String name) {
        try {
            StationRepository.addStation(new Station(name));
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public boolean deleteStation(String name) {
        try {
            Station station = StationRepository.findByName(name);
            StationRepository.deleteStation(station);
            return true;
        } catch (IllegalArgumentException error) {
            print(error.getMessage());
            return false;
        }
    }

    public List<Station> findAll() {
        if (StationRepository.stations().isEmpty()) {
            print(ErrorMessage.EMPTY_STATION);
            return Collections.emptyList();
        }
        return StationRepository.stations();
    }
}
