package subway.view;

import subway.controller.ManageController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.function.Functionable;

public class OutputView {

    public static final String FUNCTION_FORMAT = "%s. %s\n";

    public static final String MESSAGE_FORMAT = "%s %s\n";

    public static final String LIST_FORMAT = "%s 목록";

    public static final String VIEW_FORMAT = "%s 화면";

    public static final String SAVED_FORMAT = "지하철 %s이 등록되었습니다.";

    public static final String REMOVED_FORMAT = "지하철 %s이 삭제되었습니다.";

    public static final String TITLE_PREFIX = "##";

    public static final String SUCCESS_PREFIX = "[INFO]";

    public static final String SUBWAY_MAP = "지하철 노선도";

    public static final String HORIZONTAL_RULE = "---";

    private OutputView() {}

    public static void printSaved(String type) {
        printMessage(String.format(SAVED_FORMAT, type));
    }

    public static void printRemoved(String type) {
        printMessage(String.format(REMOVED_FORMAT, type));
    }

    public static void printTitleAndStations(StationRepository stationRepository) {
        printTitle(String.format(LIST_FORMAT, ManageController.STATION));
        printStations(stationRepository);
    }

    public static void printLines(LineRepository lineRepository) {
        printTitle(String.format(LIST_FORMAT, ManageController.LINE));

        for (String lineName : lineRepository.lineNames()) {
            printMessage(lineName);
        }

        System.out.println();
    }

    public static void printSubwayMap(LineRepository lineRepository) {
        printTitle(SUBWAY_MAP);

        for (Line line : lineRepository.lines()) {
            printMessage(line.getName());
            printMessage(HORIZONTAL_RULE);
            printStations(line.getStations());
        }
    }

    public static void printFunctions(String viewTitle, Functionable[] functionables) {
        printTitle(String.format(VIEW_FORMAT, viewTitle));

        for (Functionable functionable : functionables) {
            System.out
                    .printf(FUNCTION_FORMAT, functionable.getIdentifier(),
                            functionable.getDescription());
        }
    }

    private static void printStations(StationRepository stationRepository) {
        for (String stationName : stationRepository.stationNames()) {
            printMessage(stationName);
        }

        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.printf(MESSAGE_FORMAT, SUCCESS_PREFIX, message);
    }

    private static void printTitle(String message) {
        System.out.printf(MESSAGE_FORMAT, TITLE_PREFIX, message);
    }
}
