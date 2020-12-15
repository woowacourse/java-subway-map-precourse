package subway.view;

public class OutputViewOfInfo {
    private static final String INFO = "[INFO] ";
    private static final String INFO_LINE = "---";

    private static final String REGISTER_STATION_COMPLETE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_COMPLETE = "지하철 역이 삭제되었습니다.";
    private static final String REGISTER_LINE_COMPLETE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_LINE_COMPLETE = "지하철 노선이 삭제되었습니다.";
    private static final String REGISTER_SECTION_COMPLETE = "구간이 등록되었습니다.";
    private static final String DELETE_SECTION_COMPLETE = "구간이 삭제되었습니다.";


    public static void registerStationComplete() {
        System.out.println(INFO + REGISTER_STATION_COMPLETE + "\n");
    }

    public static void deleteStationComplete() {
        System.out.println(INFO + DELETE_STATION_COMPLETE + "\n");
    }

    public static void registerLineComplete() {
        System.out.println(INFO + REGISTER_LINE_COMPLETE + "\n");
    }

    public static void deleteLineComplete() {
        System.out.println(INFO + DELETE_LINE_COMPLETE + "\n");
    }

    public static void registerSectionComplete() {
        System.out.println(INFO + REGISTER_SECTION_COMPLETE + "\n");
    }

    public static void deleteSectionComplete() {
        System.out.println(INFO + DELETE_SECTION_COMPLETE + "\n");
    }

    public static void printStations(String name) {
        System.out.println(INFO + name);
    }
}
