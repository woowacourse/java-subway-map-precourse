package subway.service.section;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.repository.TransitMapRepository;
import subway.view.output.line.LineExceptionView;
import subway.view.output.section.SectionExceptionView;
import subway.view.output.station.StationExceptionView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
}
