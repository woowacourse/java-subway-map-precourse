package subway.service.section.addition;

import subway.domain.Section;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.type.BoundaryType;
import subway.view.output.line.LineExceptionView;
import subway.view.output.section.SectionExceptionView;
import subway.view.output.station.StationExceptionView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * SectionAdditionValidation.java : 지하철 구간 추가 로직 검증에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionAdditionValidation {
    public boolean checkSectionAdditionValidation(Section section) {
        if (!checkNamesValidation(section.getLineName(), section.getStationName())) {
            return false;
        }
        return checkOrderValidation(section.getLineName(), section.getOrder());
    }

    public boolean checkNamesValidation(String lineName, String stationName) {
        if (!checkLineNameExistence(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        if (!checkStationNameExistence(stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        if (checkStationNameInLineExistence(lineName, stationName)) {
            SectionExceptionView.printInvalidSectionStationNameInLineExistenceException();
            return false;
        }
        return true;
    }

    public static boolean checkLineNameExistence(String lineName) {
        List<String> lineNames = LineRepository.lineNames();
        return lineNames.contains(lineName);
    }

    public static boolean checkStationNameExistence(String stationName) {
        List<String> stationNames = StationRepository.stationNames();
        return stationNames.contains(stationName);
    }

    public static boolean checkStationNameInLineExistence(String lineName, String stationName) {
        List<String> stationNameValues = new ArrayList<>();
        LinkedList<Station> stationValues
                = SectionAdditionService.getStationValuesInLine(lineName);

        for (Station stationValue : stationValues) {
            stationNameValues.add(stationValue.getName());
        }
        return stationNameValues.contains(stationName);
    }

    public boolean checkOrderValidation(String lineName, String order) {
        if (checkOrderReplacementLength(order)) {
            SectionExceptionView.printInvalidSectionOrderReplacementLengthException();
            return false;
        }
        if (Integer.parseInt(order) < BoundaryType.ORDER_NUMBER_BOUNDARY.getBoundary()) {
            SectionExceptionView.printInvalidSectionOrderNumberException();
            return false;
        }
        if (checkOrderNumberByStations(lineName, Integer.parseInt(order))) {
            SectionExceptionView.printInvalidSectionOrderNumberByStationsException();
            return false;
        }
        return true;
    }

    public static boolean checkOrderReplacementLength(String order) {
        return order.replaceAll("[^0-9]", "").length()
                == BoundaryType.ORDER_REPLACEMENT_LENGTH_BOUNDARY.getBoundary();
    }

    public static boolean checkOrderNumberByStations(String lineName, int orderNumber) {
        LinkedList<Station> stationValues = SectionAdditionService.getStationValuesInLine(lineName);
        return stationValues.size() + 1 < orderNumber;
    }
}
