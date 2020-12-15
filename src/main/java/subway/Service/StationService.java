package subway.Service;

import subway.Exception.StationException.*;
import subway.Manager.StationManager;
import subway.domain.LineStationRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {
    private static final StationRepository stationRepository = new StationRepository();

    public void addStation(String stationName) {
        try {
            isValidStation(stationName);
            StationRepository.addStation(new Station(stationName));
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            StationManager.execute();
        }
    }

    public void deleteStation(String deleteStationName) {
        try {
            isPossibleDeleteStation(deleteStationName);
            StationRepository.deleteStation(deleteStationName);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            StationManager.execute();
        }
    }

    public void isValidStation(String name) {
        if (StationRepository.isValidStationNameLength(name)) {
            throw new ShorterThanMinStationNameException();
        }
        if (StationRepository.contains(name)) {
            throw new DuplicateStationNameException();
        }
    }

    public void isPossibleDeleteStation(String deleteStationName) {
        if (!StationRepository.contains(deleteStationName)) {
            throw new CanNotFindStationException();
        }
        if (LineStationRepository.isStationContainLine(StationRepository.findByName(deleteStationName))) {
            throw new CanNotDeleteStationException();
        }
    }

    public String stationLookup() {
        return stationRepository.toString();
    }
}
