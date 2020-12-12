package subway.view;

import subway.view.messageparts.ActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.ObjectParts;

public class SectionOutputView extends OutputView {
    public static void requestLineForAddSection() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.LINE_FOR_ADD_SECTION);
        printMessage(message);
    }

    public static void requestStationForAddSection() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.STATION_FOR_ADD_SECTION);
        printMessage(message);
    }

    public static void requestSectionOrder() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.SECTION_ORDER);
        printMessage(message);
    }

    public static void requestLineForDeleteSection() {
        String message = getRequestMessage(ActionParts.TO_DELETE, ObjectParts.LINE_FOR_DELETE_SECTION);
        printMessage(message);
    }

    public static void requestStationForDeleteSection() {
        String message = getRequestMessage(ActionParts.TO_DELETE, ObjectParts.STATION_FOR_DELETE_SECTION);
        printMessage(message);
    }

    public static void informSectionAdded() {
        String message = getInformMessage(InformSubjectParts.SECTION_IS, InformPredicateParts.ADDED);
        printInformMessage(message);
    }

    public static void informSectionDeleted() {
        String message = getInformMessage(InformSubjectParts.SECTION_IS, InformPredicateParts.DELETED);
        printInformMessage(message);
    }
}
