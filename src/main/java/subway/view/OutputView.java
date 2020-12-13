package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.ManageController;
import subway.domain.StationRepository;
import subway.domain.function.Functionable;

public class OutputView {

    public static final String TITLE_PREFIX = "##";

    public static final String SUCCESS_PREFIX = "[INFO]";

    public static final String SAVED = "지하철 %s이 등록되었습니다.";

    public static final String REMOVED = "지하철 %s이 삭제되었습니다.";

    public static final String SUBWAY_MAP = "지하철 노선도";

    public static final String HORIZONTAL_RULE = "---";

    private OutputView() {}

    public static void printSaved(String type) {
        printSuccessMessage(String.format(SAVED, type));
    }

    public static void printRemoved(String type) {
        printSuccessMessage(String.format(REMOVED, type));
    }

    public static void printTitleAndStations(StationRepository stationRepository) {
        printListTitle(ManageController.STATION);
        printStations(stationRepository);
    }

    public static void printLines(LineRepository lineRepository) {
        printListTitle(ManageController.LINE);

        for (String lineName : lineRepository.lineNames()) {
            printSuccessMessage(lineName);
        }
    }

    public static void printSubwayMap(LineRepository lineRepository) {
        System.out.printf("\n%s %s\n", TITLE_PREFIX, SUBWAY_MAP);

        for (Line line : lineRepository.lines()) {
            System.out.printf("%s %s\n", SUCCESS_PREFIX, line.getName());
            System.out.printf("%s %s\n", SUCCESS_PREFIX, HORIZONTAL_RULE);
            printStations(line.getStations());
        }
    }

    public static void printFunctions(String viewTitle, Functionable[] functionables) {
        System.out.printf("\n%s %s 화면\n", TITLE_PREFIX, viewTitle);

        for (Functionable functionable : functionables) {
            System.out
                    .printf("%s. %s\n", functionable.getIdentifier(),
                            functionable.getDescription());
        }
    }

    private static void printStations(StationRepository stationRepository) {
        for (String stationName : stationRepository.stationNames()) {
            System.out.printf("%s %s\n", SUCCESS_PREFIX, stationName);
        }
    }

    private static void printSuccessMessage(String message) {
        System.out.printf("\n%s %s\n", SUCCESS_PREFIX, message);
    }

    private static void printListTitle(String type) {
        System.out.printf("\n%s %s 목록\n", TITLE_PREFIX, type);
    }
}
