package subway.message;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Message {
    private static final String subwayLine = "## 지하철 노선도";
    private static final String error = "\n[ERROR] 선택할 수 없는 기능입니다.";
    private static final String createStation = "\n## 등록할 역 이름을 입력하세요.";
    private static final String successStation = "\n[INFO] 지하철 역이 등록되었습니다.";
    private static final String ERROR_LENGTH_NAME = "\n[ERROR] 이름은 2글자 이상이어야 합니다.";
    private static final String ERROR_NAME = "\n[ERROR] 이름은 역으로 끝나야 합니다.";
    private static final String INPUT_DELETE_STATION = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_INFO = "\n[INFO] 지하철 역이 삭제되었습니다.";
    private static final String NOT_EXIST_STATION = "\n[ERROR] 존재하지 않는 역입니다.";
    private static final String STATIONS = "\n역목록";
    private static final String INFO = "[INFO] ";
    private static final String EXIST_STATION = "\n[ERROR] 이미 존재하는 역입니다.";

    private Message() {
    }

    public static void printSubwayLineMessage() {
        System.out.println(subwayLine);
    }

    public static void printError() {
        System.out.println(error);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printCreateStation() {
        System.out.println(createStation);
    }

    public static void printSuccessStation() {
        System.out.println(successStation);
    }

    public static void printNameLengthError() {
        System.out.println(ERROR_LENGTH_NAME);
    }

    public static void printNameError() {
        System.out.println(ERROR_NAME);
    }

    public static void printDeleteStation() {
        System.out.println(INPUT_DELETE_STATION);
    }

    public static void deleteStationInfo() {
        System.out.println(DELETE_STATION_INFO);
    }

    public static void printIsNotExist() {
        System.out.println(NOT_EXIST_STATION);
    }

    public static void printStations() {
        System.out.println(STATIONS);
    }

    public static void printStation(String name) {
        System.out.println(INFO + name);
    }

    public static void printIsExist() {
        System.out.println(EXIST_STATION);
    }
}
