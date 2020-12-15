package view;

public class OutputView {
    private static final String STATION_LIST = "\n## 역 목록";
    private static final String STATION_INSERT_SUCCESS = "\n[INFO] 지하철 역이 등록되었습니다\n";
    private static final String STATION_DELETE_SUCCESS = "\n[INFO] 지하철 역이 삭제되었습니다\n";

    private static final String LINE_LIST = "\n## 노선 목록";
    private static final String LINE_INSERT_SUCCESS = "\n[INFO] 지하철 노선이 등록되었습니다\n";
    private static final String LINE_DELETE_SUCCESS = "\n[INFO] 지하철 노선이 삭제되었습니다\n";

    private static final String SECTION_INSERT_SUCCESS = "\n[INFO] 구간이 등록되었습니다\n";
    private static final String SECTION_DELETE_SUCCESS = "\n[INFO] 구간이 삭제되었습니다\n";

    private static final String PRINT_SUBWAY_MAP = "\n## 지하철 노선도";

    private static final String FINISH_SUBWAY_PROGRAM = "\n[END] 지하철 노선도 관리 프로그램이 종료 되었습니다.";

    public static void functionView(String orderName, String actionOrder) {
        System.out.println(orderName);
        System.out.println(actionOrder);
    }

    public static void stationInsertSuccess() {
        System.out.println(STATION_INSERT_SUCCESS);
    }

    public static void stationDeleteSuccess() {
        System.out.println(STATION_DELETE_SUCCESS);
    }

    public static void stationsPrint(String stations) {
        System.out.println(STATION_LIST);
        System.out.println(stations);
    }

    public static void lineInsertSuccess() {
        System.out.println(LINE_INSERT_SUCCESS);
    }

    public static void lineDeleteSuccess() {
        System.out.println(LINE_DELETE_SUCCESS);
    }

    public static void linesPrint(String lines) {
        System.out.println(LINE_LIST);
        System.out.println(lines);
    }

    public static void sectionInsertSuccess() {
        System.out.println(SECTION_INSERT_SUCCESS);
    }

    public static void sectionDeleteSuccess() {
        System.out.println(SECTION_DELETE_SUCCESS);
    }

    public static void printSubwayMap(String subwayMap) {
        System.out.println(PRINT_SUBWAY_MAP);
        System.out.print(subwayMap);
    }

    public static void printFinishProgram() {
        System.out.println(FINISH_SUBWAY_PROGRAM);
    }
}
