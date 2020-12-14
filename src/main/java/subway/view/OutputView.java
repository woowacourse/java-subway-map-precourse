package subway.view;

import java.util.List;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.RequestActionParts;
import subway.view.messageparts.RequestObjectParts;

public class OutputView {
    private static final String MESSAGE_FORMAT = "## %s%n";
    private static final String INFORM_FORMAT = "[INFO] %s%n";
    private static final String ERROR_FORMAT = "[ERROR] %s%n";
    private static final String REQUEST_INPUT_FORMAT = "%s입력하세요.";

    protected static void printList(String title, List<String> listItems) {
        printMessage(title);
        for (String listItem : listItems) {
            printListItem(listItem);
        }

        InputView.waitForEmptyInput();
    }

    protected static void printListItem(String listItem) {
        System.out.printf(INFORM_FORMAT, listItem);
    }

    public static void printError(Exception exception) {
        System.out.printf(ERROR_FORMAT, exception.getMessage());
        printEmptyLine();
    }

    protected static void printMessage(String message) {
        System.out.printf(MESSAGE_FORMAT, message);
    }

    protected static void printInformMessage(String informnation) {
        System.out.printf(INFORM_FORMAT, informnation);
        InputView.waitForEmptyInput();
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    protected static String getRequestMessage(RequestActionParts action, RequestObjectParts object) {
        return String.format(REQUEST_INPUT_FORMAT, action.toString() + object.toString());
    }

    protected static String getInformMessage(InformSubjectParts subject, InformPredicateParts predicate) {
        return (subject.toString() + predicate.toString());
    }
}
