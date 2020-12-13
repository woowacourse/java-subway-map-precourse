package subway.view;

import subway.view.messageparts.RequestActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.RequestObjectParts;

public class SectionOutputView extends OutputView {
    public static void requestLineForAddSection() {
        String message = getRequestMessage(
            RequestActionParts.TO_ADD, 
            RequestObjectParts.LINE_FOR_ADD_SECTION);
        printMessage(message);
    }

    public static void requestStationForAddSection() {
        String message = getRequestMessage(
            RequestActionParts.TO_ADD, 
            RequestObjectParts.STATION_FOR_ADD_SECTION);
        printMessage(message);
    }

    public static void requestSectionOrder() {
        String message = getRequestMessage(
            RequestActionParts.TO_ADD, 
            RequestObjectParts.SECTION_ORDER);
        printMessage(message);
    }

    public static void requestLineForDeleteSection() {
        String message = getRequestMessage(
            RequestActionParts.TO_DELETE, 
            RequestObjectParts.LINE_FOR_DELETE_SECTION);
        printMessage(message);
    }

    public static void requestStationForDeleteSection() {
        String message = getRequestMessage(
            RequestActionParts.TO_DELETE, 
            RequestObjectParts.STATION_FOR_DELETE_SECTION);
        printMessage(message);
    }

    public static void informSectionAdded() {
        String message = getInformMessage(
            InformSubjectParts.SECTION_IS, 
            InformPredicateParts.ADDED);
        printInformMessage(message);
    }

    public static void informSectionDeleted() {
        String message = getInformMessage(
            InformSubjectParts.SECTION_IS, 
            InformPredicateParts.DELETED);
        printInformMessage(message);
    }
}
