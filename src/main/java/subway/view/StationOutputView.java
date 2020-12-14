package subway.view;

import subway.domain.StationRepository;
import subway.view.messageparts.RequestActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.RequestObjectParts;

public class StationOutputView extends OutputView {
    private static final String STATION_LIST = "역 목록";

    public static void requestStationNameToAdd() {
        String message = getRequestMessage(
            RequestActionParts.TO_ADD, 
            RequestObjectParts.STATION_NAME);
        printMessage(message);
    }

    public static void requestStationNameToDelete() {
        String message = getRequestMessage(
            RequestActionParts.TO_DELETE, 
            RequestObjectParts.STATION_NAME);
        printMessage(message);
    }

    public static void informStationAdded() {
        String message = getInformMessage(
            InformSubjectParts.STATION_IS, 
            InformPredicateParts.ADDED);
        printInformMessage(message);
    }

    public static void informStationDeleted() {
        String message = getInformMessage(
            InformSubjectParts.STATION_IS, 
            InformPredicateParts.DELETED);
        printInformMessage(message);
    }

    public static void printStationList() {
        printList(STATION_LIST, StationRepository.getStationList());
    }
}
