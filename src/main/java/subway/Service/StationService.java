package subway.Service;

import subway.Manager.StationManager;
import subway.domain.LineStationRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import validator.ExceptionMessage;

public class StationService {
    private static final String STATION_INSERT = "1";
    private static final String STATION_DELETE = "2";
    private static final StationRepository stationRepository = new StationRepository();
    private static final int MIN_STATION_NAME_LENGTH = 2;


    public void addStation(String stationName) {
        try {
            isValidStationName(stationName);
            StationRepository.addStation(new Station(stationName));
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            StationManager.execute(STATION_INSERT);
        }
    }

    public void deleteStation(String deleteStationName) {
        try {
            if (LineStationRepository.isStationContainSubwayLine(StationRepository.findByName(deleteStationName))) {
                throw new IllegalArgumentException(ExceptionMessage.STATION_IS_IN_LINE);
            }
            if (!StationRepository.deleteStation(deleteStationName)) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_DELETE_STATION);
            }
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            StationManager.execute(STATION_DELETE);
        }
    }

    public void isValidStationName(String name) {
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NAME_OVER_TWO);
        }
        if (StationRepository.contains(name)) {
            throw new IllegalArgumentException(ExceptionMessage.STATION_NAME_EXISTS);
        }
    }

    public String stationLookup() {
        return stationRepository.toString();
    }
}
