package subway.service.section;

import subway.domain.Section;
import subway.type.BoundaryType;
import subway.view.output.line.LineExceptionView;
import subway.view.output.section.SectionExceptionView;
import subway.view.output.station.StationExceptionView;

public class SectionAddingValidation {
    public boolean checkSectionAddingValidation(Section section) {
        if (!checkNamesValidation(section.getLineName(), section.getStationName())) {
            return false;
        }
        if (!checkOrderValidation(section.getLineName(), section.getOrder())) {
            return false;
        }
        return true;
    }

    public boolean checkNamesValidation(String lineName, String stationName) {
        if (!SectionAddingService.checkExistingLineName(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        if (!SectionAddingService.checkExistingStationName(stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        if (SectionAddingService.checkExistingStationNameInLine(lineName, stationName)) {
            SectionExceptionView.printInvalidSectionExistingStationNameInLine();
            return false;
        }
        return true;
    }

    public boolean checkOrderValidation(String lineName, String order) {
        if (SectionAddingService.checkOrderReplacementLength(order)) {
            SectionExceptionView.printInvalidSectionOrderReplacementLengthException();
            return false;
        }
        if (Integer.parseInt(order) < BoundaryType.ORDER_NUMBER_BOUNDARY.getBoundary()) {
            SectionExceptionView.printInvalidSectionOrderNumberException();
            return false;
        }
        if (SectionAddingService.checkOrderNumberByStations(lineName, Integer.parseInt(order))) {
            SectionExceptionView.printInvalidSectionOrderNumberByStationsException();
            return false;
        }
        return true;
    }
}
