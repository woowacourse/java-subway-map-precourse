package subway.service.section;

import subway.repository.LineRepository;
import subway.type.BoundaryType;
import subway.view.output.line.LineExceptionView;
import subway.view.output.section.SectionExceptionView;
import subway.view.output.station.StationExceptionView;

import java.util.List;

public class SectionAddingValidation {
    public boolean checkLineNameValidation(String lineName) {
        List<String> lineNames = LineRepository.lineNames();

        if (!lineNames.contains(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        return true;
    }

    public boolean checkStationNameValidation(String lineName, String stationName) {
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
