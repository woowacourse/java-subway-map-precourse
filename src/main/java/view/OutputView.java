package view;

public class OutputView {
    private static final String MAIN_VIEW = "\n## 메인화면";
    private static final String MAIN_FUNCTION = "1. 역관리\n" + "2. 노선관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료";
    private static final String STATION_MAIN = "\n## 역 관리 화면";
    private static final String STATION_FUNCTION = "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기";
    private static final String STATION_INSERT_SUCCESS = "\n[INFO] 지하철 역이 등록되었습니다\n";
    private static final String STATION_DELETE_SUCCESS = "\n[INFO] 지하철 역이 삭제되었습니다\n";
    private static final String LINE_MAIN = "\n## 노선 관리 화면";
    private static final String LINE_FUNCTION = "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기";
    private static final String LINE_INSERT_SUCCESS = "\n[INFO] 지하철 노선이 등록되었습니다\n";
    private static final String LINE_DELETE_SUCCESS = "\n[INFO] 지하철 노선이 삭제되었습니다\n";
    private static final String SECTION_MAIN = "\n## 구간 관리 화면";
    private static final String SECTION_FUNCTION = "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기";

    public static void mainView() {
        System.out.println(MAIN_VIEW);
        System.out.println(MAIN_FUNCTION);
    }

    public static void stationManageView() {
        System.out.println(STATION_MAIN);
        System.out.println(STATION_FUNCTION);
    }

    public static void stationInsertSuccess() {
        System.out.println(STATION_INSERT_SUCCESS);
    }

    public static void stationDeleteSuccess() {
        System.out.println(STATION_DELETE_SUCCESS);
    }

    public static void stationLookup(String stations) {
        System.out.println(stations);
    }

    public static void lineManageView() {
        System.out.println(LINE_MAIN);
        System.out.println(LINE_FUNCTION);
    }

    public static void lineInsertSuccess() {
        System.out.println(LINE_INSERT_SUCCESS);
    }

    public static void lineDeleteSuccess() {
        System.out.println(LINE_DELETE_SUCCESS);
    }

    public static void lineLookup(String lines) {
        System.out.println(lines);
    }

    public static void sectionManageView() {
        System.out.println(SECTION_MAIN);
        System.out.println(SECTION_FUNCTION);
    }
}
