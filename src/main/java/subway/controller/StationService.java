package subway.controller;

import java.util.Collections;
import java.util.List;
import subway.domain.Station;
import subway.message.Message;
import subway.repository.StationRepository;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class StationService {

    public boolean addStation(String name) {
        if (isNotExistStation(name)) {
            StationRepository.addStation(new Station(name));
            return true;
        }
        Message.printIsExist();
        return false;
    }

    private boolean isNotExistStation(String name) {
        return !StationRepository.isExist(name);
    }

    public boolean deleteStation(String name) {
        if (StationRepository.deleteStation(name)) {
            return true;
        }
        Message.printIsNotExist();
        return false;
    }

    public List<Station> findAll() {
        if (StationRepository.stations().isEmpty()) {
            Message.printIsEmptyStation();
            return Collections.emptyList();
        }
        return StationRepository.stations();
    }
}
