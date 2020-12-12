package subway.view;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ASK_STATION_NAME_MESSAGE = "등록할 역 이름을 입력하세요.\n";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void warnMessage(String warnMessage) {
        System.out.println(ERROR_PREFIX + warnMessage);
    }

    public static void askStationName() {
        System.out.println(SHARP_PREFIX + ASK_STATION_NAME_MESSAGE);
    }
}
