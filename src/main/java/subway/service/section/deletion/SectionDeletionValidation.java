package subway.service.section.deletion;

import subway.repository.TransitMapRepository;
import subway.type.BoundaryType;
import subway.view.output.line.LineExceptionView;
import subway.view.output.section.SectionExceptionView;
import subway.view.output.station.StationExceptionView;

import java.util.List;

/**
 * SectionDeletionValidation.java : 지하철 구간 삭제 로직 검증에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionDeletionValidation {
    public boolean checkSectionDeletionValidation(String lineName, String stationName) {
        if (!checkLineNameValidation(lineName)) {
            return false;
        }
        if (!checkStationNameValidation(lineName, stationName)) {
            return false;
        }
        return checkStationsInLineValidation(lineName);
    }

    public boolean checkLineNameValidation(String lineName) {
        if (!checkLineNameInTransitMapExistence(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        return true;
    }

    public static boolean checkLineNameInTransitMapExistence(String lineName) {
        List<String> transitMapsLineNames = TransitMapRepository.transitMapsLineNames();
        return transitMapsLineNames.contains(lineName);
    }

    public boolean checkStationNameValidation(String lineName, String stationName) {
        if (!checkStationNameInTransitMapExistence(lineName, stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        return true;
    }

    public static boolean checkStationNameInTransitMapExistence(String lienName, String stationName) {
        List<String> transitMapStations = TransitMapRepository.transitMapStations(lienName);
        return transitMapStations.contains(stationName);
    }

    private boolean checkStationsInLineValidation(String lineName) {
        if (checkStationsInLineExistence(lineName)) {
            SectionExceptionView.printInvalidNumberOfSectionStationsInLineException();
            return false;
        }
        return true;
    }

    public static boolean checkStationsInLineExistence(String lineName) {
        List<String> transitMapStations = TransitMapRepository.transitMapStations(lineName);
        return transitMapStations.size() <= BoundaryType.STATIONS_IN_LINE_BOUNDARY.getBoundary();
    }
}
