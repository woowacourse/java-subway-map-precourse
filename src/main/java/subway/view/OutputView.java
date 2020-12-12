package subway.view;

import java.io.PrintStream;

import subway.domain.StationRepository;

public class OutputView {

    public static final String TITLE_PREFIX = "##";

    public static final String SUCCESS_PREFIX = "[INFO]";

    public static final String STATION_SAVED = "지하철 역이 등록되었습니다.";

    public static final String STATION_REMOVED = "지하철 역이 삭제되었습니다.";

    public static final String STATION_LIST = "역 목록";

    public static final String LINE_SAVED = "지하철 노선이 등록되었습니다.";

    public void printLineSaved() {
        printSuccessMessage(LINE_SAVED);
    }

    public void printStationSaved() {
        printSuccessMessage(STATION_SAVED);
    }

    public void printStationRemoved() {
        printSuccessMessage(STATION_REMOVED);
    }

    public void printStations(StationRepository stationRepository) {
        System.out.printf("%s %s", TITLE_PREFIX, STATION_LIST);

        for (String stationName : stationRepository.stationNames()) {
            printSuccessMessage(stationName);
        }
    }

    private PrintStream printSuccessMessage(String message) {
        return System.out.printf("%s %s", SUCCESS_PREFIX, message);
    }
}
