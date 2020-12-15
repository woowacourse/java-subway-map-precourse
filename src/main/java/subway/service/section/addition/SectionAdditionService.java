package subway.service.section.addition;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.TransitMapRepository;

import java.util.*;

public class SectionAdditionService {
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

    public static void addSection(Section section) {
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();
        int orderNumber = Integer.parseInt(section.getOrder()) - 1;

        for (Map.Entry<Line, LinkedList<Station>> entry : transitMaps.entrySet()) {
            Line key = entry.getKey();
            String keyName = key.getName();
            LinkedList<Station> values = entry.getValue();

            if (keyName.equals(section.getLineName())) {
                values.add(orderNumber, new Station(section.getStationName()));
            }
        }
    }
}
