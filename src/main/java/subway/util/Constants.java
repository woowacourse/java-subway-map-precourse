package subway.util;

public class Constants {
    public static final String ASK_COMMAND = "## 원하는 기능을 선택하세요.";
    public static final String COMMAND_FAIL = "[ERROR] 선택할 수 없는 기능입니다.\n";
    public static final String NAME_LENGTH_FAIL = "[ERROR] 이름은 2글자 이상이어야 합니다.";
    public static final String ORDER_MUST_INT = "[ERROR] 순서는 숫자여야 합니다.";
    public static final String PRINT_MAP = "## 지하철 노선도";
    // 메인 화면
    public static final String MAIN = "## 메인 화면";
    public static final String MAIN_STATION = "1. 역 관리";
    public static final String MAIN_LINE = "2. 노선 관리";
    public static final String MAIN_SECTION = "3. 구간 관리";
    public static final String MAIN_PRINT = "4. 지하철 노선도 출력";
    public static final String MAIN_QUIT = "Q. 종료";
    public static final String GO_BACK = "B. 돌아가기";
    // 역 화면
    public static final String STATION_MAIN = "## 역 관리 화면";
    public static final String STATION_ADD = "1. 역 등록";
    public static final String STATION_REMOVE = "2. 역 삭제";
    public static final String STATION_VISIT = "3. 역 조회";
    public static final String STATION_LIST = "## 역 목록";
    public static final String ASK_STATION_ADD = "## 등록할 역 이름을 입력하세요.";
    public static final String ASK_STATION_REMOVE = "## 삭제할 역 이름을 입력하세요.";
    public static final String STATION_ADD_COMPLETE = "[INFO] 지하철 역이 등록되었습니다.\n";
    public static final String STATION_REMOVE_COMPLETE = "[INFO] 지하철 노선이 삭제되었습니다.\n";
    public static final String STATION_REMOVE_FAIL = "[ERROR] 해당 역은 삭제할 수 없습니다.\n";
    public static final String STATION_NOT_EXIST = "[ERROR] 해당 역은 존재하지 않습니다.\n";
    public static final String STATION_EXIST = "[ERROR] 이미 등록된 역이름입니다.\n";
    // 노선 화면
    public static final String LINE_MAIN = "## 노선 관리 화면";
    public static final String LINE_ADD = "1. 노선 등록";
    public static final String LINE_REMOVE = "2. 노선 삭제";
    public static final String LINE_VISIT = "3. 노선 조회";
    public static final String LINE_LIST = "## 노선 목록";
    public static final String ASK_LINE_ADD = "## 등록할 노선 이름을 입력하세요.";
    public static final String ASK_LINE_REMOVE = "## 삭제할 노선 이름을 입력하세요..";
    public static final String ASK_UPPER_END = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String ASK_LOWER_END = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String LINE_ADD_COMPLETE = "[INFO] 지하철 노선이 등록되었습니다.\n";
    public static final String LINE_REMOVE_COMPLETE = "[INFO] 지하철 노선이 삭제되었습니다.\n";
    public static final String LINE_REMOVE_FAIL = "[ERROR] 해당 노선은 삭제할 수 없습니다.\n";
    public static final String LINE_EXIST = "[ERROR] 이미 등록된 노선이름입니다.\n";
    public static final String LINE_NOT_EXIST = "[ERROR] 해당 노선은 존재하지 않습니다.\n";
    // 구간 화면
    public static final String SECTION_MAIN = "## 구간 관리 화면";
    public static final String SECTION_ADD = "1. 구간 등록";
    public static final String SECTION_REMOVE = "2. 구간 삭제";
    public static final String ASK_SECTION_ADD_LINE = "## 노선을 입력하세요.";
    public static final String ASK_SECTION_ADD_NAME = "## 역이름을 입력하세요.";
    public static final String ASK_SECTION_ADD_ORDER = "## 순서를 입력하세요.";
    public static final String ASK_SECTION_REMOVE_LINE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String ASK_SECTION_REMOVE_STATION = "## 삭제할 구간의 역을 입력하세요.";
    public static final String SECTION_ADD_COMPLETE = "[INFO] 구간이 등록되었습니다.\n";
    public static final String SECTION_REMOVE_COMPLETE = "[INFO] 구간이 삭제되었습니다.\n";
    public static final String SECTION_REMOVE_FAIL = "[ERROR] 해당 구간은 삭제할 수 없습니다.\n";

    public static void printMain() {
        System.out.println(MAIN);
        System.out.println(MAIN_STATION);
        System.out.println(MAIN_LINE);
        System.out.println(MAIN_SECTION);
        System.out.println(MAIN_PRINT);
        System.out.println(MAIN_QUIT);
        System.out.print("\n");
        System.out.println(Constants.ASK_COMMAND);
    }

    public static void printStation() {
        System.out.println(STATION_MAIN);
        System.out.println(STATION_ADD);
        System.out.println(STATION_REMOVE);
        System.out.println(STATION_VISIT);
        System.out.println(GO_BACK);
        System.out.print("\n");
        System.out.println(Constants.ASK_COMMAND);
    }

    public static void printLine() {
        System.out.println(LINE_MAIN);
        System.out.println(LINE_ADD);
        System.out.println(LINE_REMOVE);
        System.out.println(LINE_VISIT);
        System.out.println(GO_BACK);
        System.out.print("\n");
        System.out.println(Constants.ASK_COMMAND);
    }

    public static void printSection() {
        System.out.println(SECTION_MAIN);
        System.out.println(SECTION_ADD);
        System.out.println(SECTION_REMOVE);
        System.out.println(GO_BACK);
        System.out.print("\n");
        System.out.println(Constants.ASK_COMMAND);
    }
}
