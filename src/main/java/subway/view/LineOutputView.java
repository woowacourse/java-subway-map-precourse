package subway.view;

import subway.domain.LineRepository;
import subway.view.messageparts.RequestActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.RequestObjectParts;

public class LineOutputView extends OutputView {
    private static final String LINE_LIST = "노선 목록";

    public static void requestLineNameToAdd() {
        String message = getRequestMessage( 
            RequestObjectParts.LINE_NAME,
            RequestActionParts.TO_ADD);
        printMessage(message);
    }

    public static void requestUpstreamTerminus() {
        String message = getRequestMessage(
            RequestObjectParts.UPSTREAM_TERMINUS,
            RequestActionParts.TO_ADD);
        printMessage(message);
    }

    public static void requestDownstreamTerminus() {
        String message = getRequestMessage( 
            RequestObjectParts.DOWNSTREAM_TERMINUS,
            RequestActionParts.TO_ADD);
        printMessage(message);
    }

    public static void requestLineNameToDelete() {
        String message = getRequestMessage(
            RequestObjectParts.LINE_NAME,
            RequestActionParts.TO_DELETE);
        printMessage(message);
    }

    public static void informLineAdded() {
        String message = getInformMessage(
            InformSubjectParts.LINE_IS, 
            InformPredicateParts.ADDED);
        printInformMessage(message);
    }

    public static void informLineDeleted() {
        String message = getInformMessage(
            InformSubjectParts.LINE_IS, 
            InformPredicateParts.DELETED);
        printInformMessage(message);
    }

    public static void printLineList() {
        printList(LINE_LIST, LineRepository.getLineList());
    }
}
