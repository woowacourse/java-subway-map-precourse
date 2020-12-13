package subway.view;

import subway.controller.ManagementController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.function.Functionable;

public final class OutputView {

    private static final String FUNCTION_FORMAT = "%s. %s\n";

    private static final String MESSAGE_FORMAT = "%s %s\n";

    private static final String LIST_FORMAT = "%s 목록";

    private static final String VIEW_FORMAT = "%s 화면";

    private static final String SAVED_FORMAT = "지하철 %s이 등록되었습니다.\n";

    private static final String REMOVED_FORMAT = "지하철 %s이 삭제되었습니다.\n";

    private static final String TITLE_PREFIX = "##";

    private static final String SUCCESS_PREFIX = "[INFO]";

    private static final String SUBWAY_MAP = "지하철 노선도";

    private static final String HORIZONTAL_RULE = "---";

    private OutputView() {}

    public static void printSaved(final String type) {
        printMessage(String.format(SAVED_FORMAT, type));
    }

    public static void printRemoved(final String type) {
        printMessage(String.format(REMOVED_FORMAT, type));
    }

    public static void printTitleAndStations(final StationRepository stationRepository) {
        printTitle(String.format(LIST_FORMAT, ManagementController.STATION));
        printStations(stationRepository);
    }

    public static void printLines(final LineRepository lineRepository) {
        printTitle(String.format(LIST_FORMAT, ManagementController.LINE));

        for (String lineName : lineRepository.lineNames()) {
            printMessage(lineName);
        }

        System.out.println();
    }

    public static void printSubwayMap(final LineRepository lineRepository) {
        printTitle(SUBWAY_MAP);

        for (Line line : lineRepository.lines()) {
            printMessage(line.getName());
            printMessage(HORIZONTAL_RULE);
            printStations(line.getStations());
        }
    }

    public static void printFunctions(final String viewTitle, final Functionable[] functionables) {
        printTitle(String.format(VIEW_FORMAT, viewTitle));

        for (Functionable functionable : functionables) {
            System.out.printf(FUNCTION_FORMAT, functionable.getIdentifier(),
                    functionable.getDescription());
        }

        System.out.println();
    }

    private static void printStations(final StationRepository stationRepository) {
        for (String stationName : stationRepository.stationNames()) {
            printMessage(stationName);
        }

        System.out.println();
    }

    private static void printMessage(final String message) {
        System.out.printf(MESSAGE_FORMAT, SUCCESS_PREFIX, message);
    }

    private static void printTitle(final String message) {
        System.out.printf(MESSAGE_FORMAT, TITLE_PREFIX, message);
    }
}
