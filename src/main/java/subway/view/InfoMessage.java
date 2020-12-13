package subway.view;

public class InfoMessage {
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String STATION_ADDED = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETED = "지하철 역이 삭제되었습니다.";
    private static final String LINE_ADDED = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETED = "지하철 노선이 삭제되었습니다.";
    private static final String PATH_ADDED = "구간이 등록되었습니다.";
    private static final String PATH_DELETED = "구간이 삭제되었습니다.";



    private InfoMessage() {
    }

    public static void printName(String name) {
        System.out.println(INFO_PREFIX + name);
    }

    public static void printStationAdded() {
        System.out.println(INFO_PREFIX + STATION_ADDED);
    }


    public static void printStationDeleted() {
        System.out.println(INFO_PREFIX + STATION_DELETED);
    }

    public static void printLineAdded() {
        System.out.println(INFO_PREFIX + LINE_ADDED);
    }

    public static void printLineDeleted() {
        System.out.println(INFO_PREFIX + LINE_DELETED);
    }

    public static void printPathAdded() {
        System.out.println(INFO_PREFIX + PATH_ADDED);
    }

    public static void printPathDeleted() {
        System.out.println(INFO_PREFIX + PATH_DELETED);
    }


}
