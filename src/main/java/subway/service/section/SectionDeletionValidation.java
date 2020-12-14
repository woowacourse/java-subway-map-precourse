package subway.service.section;

import subway.repository.TransitMapRepository;
import subway.view.output.line.LineExceptionView;
import subway.view.output.station.StationExceptionView;

import java.util.List;

public class SectionDeletionValidation {
    public boolean checkSectionDeletionValidation(String lineName, String stationName) {
        if (!checkLineNameValidation(lineName)) {
            return false;
        }
        if (!checkStationNameValidation(lineName, stationName)) {
            return false;
        }
        return true;
    }

    public boolean checkLineNameValidation(String lineName) {
        if (!checkExistingLineNameInTransitMap(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        return true;
    }

    public boolean checkStationNameValidation(String lineName, String stationName) {
        if (!checkExistingStationNameInTransitMap(lineName, stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        return true;
    }

    public static boolean checkExistingLineNameInTransitMap(String lineName) {
        List<String> transitMapsLineNames = TransitMapRepository.transitMapsLineNames();
        return transitMapsLineNames.contains(lineName);
    }

    public static boolean checkExistingStationNameInTransitMap(String lienName, String stationName) {
        List<String> transitMapStations = TransitMapRepository.transitMapStationsByLine(lienName);
        return transitMapStations.contains(stationName);
    }
}
