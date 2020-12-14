package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationDisplay;
import subway.view.UserInput;

public class StationService {

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
}
