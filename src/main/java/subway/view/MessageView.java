package subway.view;

public class MessageView {

    public static final String STATION_ADD = "## 등록할 역 이름을 입력하세요.";
    public static final String STATION_ADD_SUCCESS = "[INFO] 지하철 역이 등록되었습니다.";
    public static final String STATION_GET_SUCCESS = "\n## 역 목록";
    public static final String STATION_REMOVE_INPUT = "## 삭제할 역 이름을 입력하세요.";
    public static final String STATION_REMOVE_SUCCESS = "[INFO] 지하철 역이 삭제되었습니다.";
    public static final String LINE_ADD = "## 등록할 노선 이름을 입력하세요.";
    public static final String LINE_ADD_SUCCESS = "[INFO] 지하철 노선이 등록되었습니다.";
    public static final String LINE_GET_SUCCESS = "\n## 노선 목록";
    public static final String LINE_REMOVE_INPUT = "## 삭제할 노선 이름을 입력하세요.";
    public static final String LINE_REMOVE_SUCCESS = "[INFO] 지하철 노선이 삭제되었습니다.";
    public static final String UPWARD_TERMINAL_STATION_NAME_INPUT = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String DOWN_TERMINAL_STATION_NAME_INPUT = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String SECTION_LINE_INPUT = "## 노선을 입력하세요.";
    public static final String SECTION_STATION_NAME_INPUT = "## 역 이름을 입력하세요.";
    public static final String SECTION_ORDER_INPUT = "## 순서를 입력하세요.";
    public static final String SECTION_REGISTER_SUCCESS = "## 구간이 등록되었습니다.";
    public static final String SECTION_REMOVE_LINE_INPUT = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String SECTION_REMOVE_STATION_INPUT = "## 삭제할 구간의 역을 입력하세요.";
    public static final String SECTION_REMOVE_SUCCESS = "[INFO] 구간이 삭제되었습니다.";
    public static final String SELECT_SELECTOR = "## 원하는 기능을 선택하세요.";
    public static final String SUBWAY_LINE_MAP = "## 지하철 노선도";

    public void printAddStationMessage() {
        System.out.println(STATION_ADD);
    }

    public void printAddStationSuccessMessage() {
        System.out.println(STATION_ADD_SUCCESS);
    }

    public void printGetStationsMessage() {
        System.out.println(STATION_GET_SUCCESS);
    }

    public void printRemoveStationMessage() {
        System.out.println(STATION_REMOVE_INPUT);
    }

    public void printRemoveStationSuccessMessage() {
        System.out.println(STATION_REMOVE_SUCCESS);
    }

    public void printAddLineMessage() {
        System.out.println(LINE_ADD);
    }

    public void printAddLineSuccessMessage() {
        System.out.println(LINE_ADD_SUCCESS);
    }

    public void printRemoveLineInputMessage() {
        System.out.println(LINE_REMOVE_INPUT);
    }

    public void printGetLinesMessage() {
        System.out.println(LINE_GET_SUCCESS);
    }

    public void printUpwardTerminalStationInputMessage() {
        System.out.println(UPWARD_TERMINAL_STATION_NAME_INPUT);
    }

    public void printDownTerminalStationInputMessage() {
        System.out.println(DOWN_TERMINAL_STATION_NAME_INPUT);
    }

    public void printRemoveLineSuccessMessage() {
        System.out.println(LINE_REMOVE_SUCCESS);
    }

    public void printSectionLineInputMessage() {
        System.out.println(SECTION_LINE_INPUT);
    }

    public void printSectionStationNameInputMessage() {
        System.out.println(SECTION_STATION_NAME_INPUT);
    }

    public void printSectionOrderInputMessage() {
        System.out.println(SECTION_ORDER_INPUT);
    }

    public void printSectionRegisterSuccessMessage() {
        System.out.println(SECTION_REGISTER_SUCCESS);
    }

    public void printSectionRemoveLineInputMessage() {
        System.out.println(SECTION_REMOVE_LINE_INPUT);
    }

    public void printSectionRemoveStationInputMessage() {
        System.out.println(SECTION_REMOVE_STATION_INPUT);
    }

    public void printSectionRemoveSuccessMessage() {
        System.out.println(SECTION_REMOVE_SUCCESS);
    }

    public void printSelectSelectorMessage() {
        System.out.println(SELECT_SELECTOR);
    }

    public void printSubwayLineMapMessage() {
        System.out.println(SUBWAY_LINE_MAP);
    }

}