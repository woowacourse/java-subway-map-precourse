package subway.service;

import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationDisplay;

public class StationService {

    public static void save(String stationName) {
        Station newStation = Station.newStationWithName(stationName);
        StationRepository.addStation(newStation);
        StationDisplay.printSaveSuccess();
    }

    public static void delete(String stationName) {
        StationRepository.deleteStation(stationName);
        StationDisplay.printDeleteSuccess();
    }

    public static void print() {
        StationDisplay.printAllStations(StationRepository.stations());
    }

    public static void registerSectionByName(Section section, String stationName, String position) {
        section.addStationWithPosition(StationRepository.getStationByName(stationName), position);
    }
}
