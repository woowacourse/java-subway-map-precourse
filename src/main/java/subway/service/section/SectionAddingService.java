package subway.service.section;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.repository.TransitMapRepository;
import subway.type.BoundaryType;
import subway.view.output.section.SectionTextView;

import java.util.*;

public class SectionAddingService {
    public static String scanLineName(Scanner scanner) {
        SectionTextView.printSectionAddingLineText();
        return scanner.nextLine();
    }

    public static String scanStationName(Scanner scanner) {
        SectionTextView.printSectionAddingStationText();
        return scanner.nextLine();
    }

    public static String scanOrder(Scanner scanner) {
        SectionTextView.printSectionAddingOrderText();
        return scanner.nextLine();
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

    public static boolean checkOrderReplacementLength(String order) {
        return order.replaceAll("[^0-9]", "").length()
                == BoundaryType.ORDER_REPLACEMENT_LENGTH_BOUNDARY.getBoundary();
    }

    public static boolean checkOrderNumberByStations(String lineName, int orderNumber) {
        LinkedList<Station> stationValues = getStationValuesInLine(lineName);
        return stationValues.size() < orderNumber;
    }
}
