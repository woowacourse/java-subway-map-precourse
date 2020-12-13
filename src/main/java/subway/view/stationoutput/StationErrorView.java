package subway.view.stationoutput;

import subway.view.ErrorView;

public class StationErrorView extends ErrorView {
    private static final String ERROR_WRONG_LENGTH = "2자 미만은 입력할 수 없습니다.";
    private static final String ERROR_WRONG_DUPLICATE_STATION = "이미 등록된 역 이름입니다.";
    private static final String ERROR_END_WITH_WORD_STATION = "등록할 역 이름은 '역'으로 끝나야 합니다";
    private static final String ERROR_INPUT_IS_SPACE = "공백으로만 이루어진 입력은 허용하지 않습니다.";
    private static final String ERROR_NOT_IN_STATION_REPOSITORY = "존재하지 않는 역입니다.";

    public static void printLengthError() {
        System.out.println(ERROR + ERROR_WRONG_LENGTH);
    }

    public static void printDuplicateStationError() {
        System.out.println(ERROR + ERROR_WRONG_DUPLICATE_STATION);
    }

    public static void printInputIsSpaceError() {
        System.out.println(ERROR + ERROR_INPUT_IS_SPACE);
    }

    public static void printEndWithWordStationError() {
        System.out.println(ERROR + ERROR_END_WITH_WORD_STATION);
    }

    public static void printNotInStationRepositoryError() {
        System.out.println(ERROR + ERROR_NOT_IN_STATION_REPOSITORY);
    }
}
