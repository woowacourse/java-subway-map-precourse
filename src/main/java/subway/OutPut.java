package subway;

public class OutPut {

    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";
    private static final String STATION_NAME_LENGTH_ERROR = "지하철 역의 이름은 2글자 이상이여야 합니다.\n";
    private static final String STATION_CREATE_MESSAGE = "지하철 역이 등록되었습니다.\n";
    private static final String STATION_NAME_DUPLICATE_ERROR = "지하철 역의 이름은 중복될 수 없습니다.\n";
    private static final String LINE_NAME_LENGTH_ERROR = "지하철 노선의 이름은 2글자 이상이여야 합니다.\n";
    private static final String LINE_NAME_DUPLICATE_ERROR = "지하철 노선의 이름은 중복될 수 없습니다.\n";
    private static final String LINE_CREATE_MESSAGE = "지하철 노선이 등록되었습니다.\n";
    private static final String NON_EXIST_STATION_ERROR = "은(는) 존재하지 않는 역입니다.\n";
    private static final String NON_EXIST_LINE_ERROR = "존재하지 않는 노선입니다.\n";
    private static final String EXIST_STATION_ERROR = "노선에 이미 존재하는 역입니다.\n";
    private static final String SECTION_ADD_MESSAGE = "구간이 등록되었습니다.\n";
    private static final String STATION_DELETE_ERROR = "노선에 등록된 지하철 역은 삭제할 수 없습니다.\n";
    private static final String STATION_DELETE_MESSAGE = "지하철 역이 삭제되었습니다.\n";

    public static void printStationNameLengthError() {
        System.out.println(ERROR + STATION_NAME_LENGTH_ERROR);
    }

    public static void printStationCreateMessage() {
        System.out.println(INFO + STATION_CREATE_MESSAGE);
    }

    public static void printStationNameDuplicateError() {
        System.out.println(ERROR + STATION_NAME_DUPLICATE_ERROR);
    }

    public static void printLineLengthError() {
        System.out.println(ERROR + LINE_NAME_LENGTH_ERROR);
    }

    public static void printLineDuplicateError() {
        System.out.println(ERROR + LINE_NAME_DUPLICATE_ERROR);
    }

    public static void printLineCreateMessage() {
        System.out.println(INFO + LINE_CREATE_MESSAGE);
    }

    public static void printNonExistStationError(String stationName) {
        System.out.println(ERROR + stationName + NON_EXIST_STATION_ERROR);
    }

    public static void printNonExistLineError() {
        System.out.println(ERROR + NON_EXIST_LINE_ERROR);
    }

    public static void printExistStationError() {
        System.out.println(ERROR + EXIST_STATION_ERROR);
    }

    public static void printSectionAddMessage() {
        System.out.println(INFO + SECTION_ADD_MESSAGE);
    }

    public static void printStationDeleteError() {
        System.out.println(ERROR + STATION_DELETE_ERROR);
    }
}
