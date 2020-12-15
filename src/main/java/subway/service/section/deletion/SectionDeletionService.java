package subway.service.section.deletion;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.TransitMapRepository;

import java.util.LinkedList;
import java.util.Map;

public class SectionDeletionService {
    public static void deleteSection(String lineName, String stationName) {
        Map<Line, LinkedList<Station>> transitMaps = TransitMapRepository.transitMaps();

        for (Map.Entry<Line, LinkedList<Station>> entry : transitMaps.entrySet()) {
            Line key = entry.getKey();
            String keyName = key.getName();
            LinkedList<Station> values = entry.getValue();

            if (keyName.equals(lineName)) {
                int order = findOrder(values, stationName);
                values.remove(order);
            }
        }
    }

    public static int findOrder(LinkedList<Station> values, String stationName) {
        int order = 0;

        for (Station value : values) {
            String valueName = value.getName();

            if (valueName.equals(stationName)) {
                order = values.indexOf(value);
            }
        }
        return order;
    }
}
