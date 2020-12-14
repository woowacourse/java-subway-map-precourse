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

    public static boolean checkExistingStationName(String stationName) {
        List<String> stationNames = StationRepository.stationNames();
        return stationNames.contains(stationName);
    }

    public static boolean checkExistingStationNameInLine(String lineName, String stationName) {
        List<String> stationNameValues = new ArrayList<>();
        LinkedList<Station> stationValues = getStationValuesInLine(lineName);

        for (Station stationValue : stationValues) {
            stationNameValues.add(stationValue.getName());
        }
        return stationNameValues.contains(stationName);
    }

    public static LinkedList<Station> getStationValuesInLine(String lineName) {
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();
        LinkedList<Station> stationValues = new LinkedList<>();

        for (Map.Entry<Line, LinkedList<Station>> entry : transitMaps.entrySet()) {
            Line key = entry.getKey();
            String keyName = key.getName();
            LinkedList<Station> values = entry.getValue();

            if (keyName.equals(lineName)) {
                stationValues = values;
            }
        }
        return stationValues;
    }

    public boolean checkStationNameValidation(String lineName, String stationName) {
        if (!checkExistingStationName(stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        if (checkExistingStationNameInLine(lineName, stationName)) {
            SectionExceptionView.printInvalidSectionExistingStationNameInLine();
            return false;
        }
        return true;
    }
}
