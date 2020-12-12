package subway.view;

import java.util.List;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.messageparts.ActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.ObjectParts;

public class StationOutputView extends OutputView {
    public static void requestStationNameToAdd() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.STATION_NAME);
        printMessage(message);
    }

    public static void requestStationNameToDelete() {
        String message = getRequestMessage(ActionParts.TO_DELETE, ObjectParts.STATION_NAME);
        printMessage(message);
    }

    public static void informStationAdded() {
        String message = getInformMessage(InformSubjectParts.STATION_IS, InformPredicateParts.ADDED);
        printInformMessage(message);
    }

    public static void informStationDeleted() {
        String message = getInformMessage(InformSubjectParts.STATION_IS, InformPredicateParts.DELETED);
        printInformMessage(message);
    }

    public static void printStations() {
        printMessage(STATION_LIST);
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            printListItem(station.getName());
        }
    }
}
