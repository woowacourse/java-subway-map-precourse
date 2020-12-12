package subway.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.messageparts.ActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.ObjectParts;

public class LineOutputView extends OutputView {
    public static void requestLineNameToAdd() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.LINE_NAME);
        printMessage(message);
    }

    public static void requestUpstreamTerminus() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.UPSTREAM_TERMINUS);
        printMessage(message);
    }

    public static void requestDownstreamTerminus() {
        String message = getRequestMessage(ActionParts.TO_ADD, ObjectParts.DOWNSTREAM_TERMINUS);
        printMessage(message);
    }

    public static void requestLineNameToDelete() {
        String message = getRequestMessage(ActionParts.TO_DELETE, ObjectParts.LINE_NAME);
        printMessage(message);
    }

    public static void informLineAdded() {
        String message = getInformMessage(InformSubjectParts.LINE_IS, InformPredicateParts.ADDED);
        printInformMessage(message);
    }

    public static void informLineDeleted() {
        String message = getInformMessage(InformSubjectParts.LINE_IS, InformPredicateParts.DELETED);
        printInformMessage(message);
    }

    public static void printLines() {
        printMessage(LINE_LIST);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printListItem(line.getName());
        }
    }
}
