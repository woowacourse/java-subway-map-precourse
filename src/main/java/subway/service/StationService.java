package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationDisplay;
import subway.view.UserInput;

public class StationService {
    private static final int ENOUGH_STATIONS = 2;

    public static void saveStation() {
        Station newStation = Station.newStationWithName(UserInput.getSaveStationName());
        StationRepository.addStation(newStation);
        StationDisplay.printSaveSuccess();
    }

    public static void deleteStation() {
        StationRepository.validateStationsEmpty();
        Station station = StationRepository.getStationByName(UserInput.getDeleteStationName());
        SectionService.validateContainStation(station);
        StationRepository.deleteStation(station);
        StationDisplay.printDeleteSuccess();
    }

    public static void printStations() {
        StationRepository.validateStationsEmpty();
        StationDisplay.printAllStations(StationRepository.stations());
    }

    public static Station getStationByName(String stationName) {
        return StationRepository.getStationByName(stationName);
    }

    public static void validateEnoughStations() {
        if (StationRepository.stations().size() < ENOUGH_STATIONS ) {
            throw new IllegalArgumentException("지하철 역의 수가 충분하지 않아 노선 등록을 진행 할 수 없습니다.");
        }
    }
}
