package subway.view;

public class OutputViewOfError {
    private static final String ERROR = "[ERROR] ";
    private static final String CANNOT_SELECT_MENU_ERROR = "선택할 수 없는 기능입니다.";
    private static final String ALREADY_EXIST_STATION_ERROR = "이미 등록된 역 이름입니다.";
    private static final String ALREADY_EXIST_LINE_ERROR = "이미 등록된 노선입니다.";
    private static final String NAME_LENGTH_ERROR = "이름은 2글자 이상이어야 합니다.";
    private static final String CANNOT_DELETE_ERROR = "삭제할 수 없습니다.";
    private static final String NOT_EXIST_STATION_ERROR = "존재하지 않는 역이름 입니다.";
    private static final String NOT_EXIST_LINE_ERROR = "존재하지 않는 노선 이름입니다.";
    private static final String NOT_VALID_ORDER_ERROR = "올바르지 않은 순서입니다. 순서는 1부터 노선에 포함된 역의 개수 + 1 까지 가능합니다.";
    private static final String CANNOT_DELETE_STATION_IN_LINE = "노선에 포함된 역이 2개 이하인 경우 삭제할 수 없습니다.";

    public static void cannotSelectMenuError() {
        System.out.println(ERROR + CANNOT_SELECT_MENU_ERROR + "\n");
    }

    public static void alreadyExistStationError() {
        System.out.println(ERROR + ALREADY_EXIST_STATION_ERROR + "\n");
    }

    public static void alreadyExistLineError() {
        System.out.println(ERROR + ALREADY_EXIST_LINE_ERROR + "\n");
    }

    public static void isNotValidNameLength() {
        System.out.println(ERROR + NAME_LENGTH_ERROR + "\n");
    }

    public static void cannotDeleteError() {
        System.out.println(ERROR + CANNOT_DELETE_ERROR + "\n");
    }

    public static void isNotExistStation() {
        System.out.println(ERROR + NOT_EXIST_STATION_ERROR + "\n");
    }

    public static void isNotExistLine() {
        System.out.println(ERROR + NOT_EXIST_LINE_ERROR + "\n");
    }

    public static void isNotValidOrder() {
        System.out.println(ERROR + NOT_VALID_ORDER_ERROR + "\n");
    }

    public static void cannotDeleteStationInLine() {
        System.out.println(ERROR + CANNOT_DELETE_STATION_IN_LINE + "\n");
    }
}
