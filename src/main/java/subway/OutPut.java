package subway;

public class OutPut {

    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";
    private static final String STATION_NAME_LENGTH_ERROR = "지하철 역의 이름은 2글자 이상이여야 합니다.\n";
    private static final String STATION_CREATE_MESSAGE = "지하철 역이 등록되었습니다.\n";
    private static final String STATION_NAME_DUPLICATE_ERROR = "지하철 역의 이름은 중복될 수 없습니다.\n";
    private static final String LINE_NAME_LENGTH_ERROR = "지하철 노선의 이름은 2글자 이상이여야 합니다.\n";

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

}
