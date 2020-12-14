package subway.service.section;

import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.output.line.LineExceptionView;
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

    public boolean checkStationNameValidation(String stationName) {
        List<String> stationNames = StationRepository.stationNames();

        if (!stationNames.contains(stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        return true;
    }
}
