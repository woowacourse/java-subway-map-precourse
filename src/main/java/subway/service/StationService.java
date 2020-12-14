package subway.service;

import subway.domain.Section;
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
        StationRepository.deleteStation(UserInput.getDeleteStationName());
        StationDisplay.printDeleteSuccess();
    }

    public static void printStations() {
        StationDisplay.printAllStations(StationRepository.stations());
    }

    public static Station getStationByName(String stationName){
        return StationRepository.getStationByName(stationName);
    }
}
