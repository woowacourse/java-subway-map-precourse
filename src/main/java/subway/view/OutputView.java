package subway.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuItem;
import subway.view.messageparts.ActionParts;
import subway.view.messageparts.InformPredicateParts;
import subway.view.messageparts.InformSubjectParts;
import subway.view.messageparts.ObjectParts;

public class OutputView {
    private static final String MESSAGE_FORMAT = "## %s%n";
    private static final String INFORM_FORMAT = "[INFO] %s%n";
    private static final String ERROR_FORMAT = "[ERROR] %s%n";
    private static final String MENU_ITEM_FORMAT = "%s. %s%n";

    private static final String REQUEST_SELECT_FUNCTION = "원하는 기능을 선택하세요.";
    private static final String REQUEST_INPUT_FORMAT = "%s입력하세요.";

    private static final String STATION_LIST = "역 목록";
    private static final String LINE_LIST = "노선 목록";

    public static void printMenu(Menu menu) {
        printMessage(menu.getTitle());
        for (MenuItem menuItem : menu) {
            printMenuItem(menuItem);
        }
    }

    private static void printMenuItem(MenuItem menuItem) {
        System.out.printf(MENU_ITEM_FORMAT, menuItem.getKey(), menuItem.getName());
    }

    public static void requestSelectFunction() {
        printMessage(REQUEST_SELECT_FUNCTION);
    }

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

    public static void printError(Exception exception) {
        printEmptyLine();
        System.out.printf(ERROR_FORMAT, exception.getMessage());
    }

    private static void printMessage(String message) {
        printEmptyLine();
        System.out.printf(MESSAGE_FORMAT, message);
    }

    private static void printInformMessage(String informnation) {
        printEmptyLine();
        System.out.printf(INFORM_FORMAT, informnation);
    }

    private static void printListItem(String listItem) {
        System.out.printf(INFORM_FORMAT, listItem);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static String getRequestMessage(ActionParts action, ObjectParts object) {
        return String.format(REQUEST_INPUT_FORMAT, action.toString() + object.toString());
    }

    private static String getInformMessage(InformSubjectParts subject, InformPredicateParts predicate) {
        return (subject.toString() + predicate.toString());
    }
}
