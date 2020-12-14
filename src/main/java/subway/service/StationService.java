package subway.service;

import java.util.List;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.validation.StationValidation;

public class StationService {

    private static final int NAME_LENGTH_LIMIT = 2;

    public static boolean addStation(String stationName) {
        if (StationValidation.checkInsertStation(stationName)) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            return true;
        }
        return false;
    }

    public static boolean deleteStation(String stationName) {
        if (StationValidation.checkDeleteStation(stationName)) {
            StationRepository.deleteStation(stationName);
            return true;
        }
        return false;
    }

    public static List<Station> findAllStation() {
        return StationRepository.stations();
    }

    public static boolean isAlreadyExistStation(String stationName) {
        return StationRepository.isDuplicateStation(new Station(stationName));
    }

    public static boolean isUnderNameLength(String name) {
        return name.length() < NAME_LENGTH_LIMIT;
    }

    public static boolean isRegisteredStation(String name) {
        return StationRepository.findByName(name).isRegistered();
    }

    public static boolean isAllStationListIsExist(List<Station> stationList) {
        for(Station station: stationList) {
            if (!StationService.isAlreadyExistStation(station.getName())) {
                return false;
            }
        }

        return true;
    }
}
