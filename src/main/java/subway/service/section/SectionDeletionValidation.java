package subway.service.section;

import subway.view.output.line.LineExceptionView;
import subway.view.output.station.StationExceptionView;

public class SectionDeletionValidation {
    public boolean checkSectionDeletionValidation(String lineName, String stationName) {
        if (!checkLineNameValidation(lineName)) {
            return false;
        }
        if (!checkStationNameValidation(stationName)) {
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

    public boolean checkStationNameValidation(String stationName) {
        if (!checkExistingStationNameInTransitMap(stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        return true;
    }

    public static boolean checkExistingLineNameInTransitMap(String lineName) {
        return false;
    }

    public static boolean checkExistingStationNameInTransitMap(String stationName) {
        return false;
    }
}
