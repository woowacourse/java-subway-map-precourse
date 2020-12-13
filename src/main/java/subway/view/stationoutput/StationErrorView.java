package subway.view.stationoutput;

import subway.view.ErrorView;

public class StationErrorView extends ErrorView {
    private static final String ERROR_WRONG_DUPLICATE_STATION = "이미 등록된 역 이름입니다.";
    private static final String ERROR_END_WITH_WORD_STATION = "등록할 역 이름은 '역'으로 끝나야 합니다";
    private static final String ERROR_NOT_IN_STATION_REPOSITORY = "존재하지 않는 역입니다.";

    public static void printDuplicateStationError() {
        printError(ERROR_WRONG_DUPLICATE_STATION);
    }

    public static void printEndWithWordStationError() {
        printError(ERROR_END_WITH_WORD_STATION);
    }

    public static void printNotInStationRepositoryError() {
        printError(ERROR_NOT_IN_STATION_REPOSITORY);
    }
}
