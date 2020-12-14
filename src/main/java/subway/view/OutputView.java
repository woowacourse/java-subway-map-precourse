package subway.view;

public class OutputView {
	private static final String MAIN_MESSAGE = "## 메인 화면";
	private static final String MAIN_STATION_MESSAGE = "1. 역 관리";
	private static final String MAIN_LINE_MESSAGE = "2. 노선 관리";
	private static final String MAIN_SECTION_MESSAGE = "3. 구간 관리";
	private static final String MAIN_MAP_PRINT_MESSAGE = "4. 지하철 노선도 출력";

	private static final String STATION_MANAGE_MESSAGE = "## 역 관리 화면";
	private static final String STATION_REGISTER_MESSAGE = "1. 역 등록";
	private static final String STATION_DELETE_MESSAGE = "2. 역 삭제";
	private static final String STATION_PRINT_MESSAGE = "3. 역 조회";

	private static final String LINE_MANAGE_MESSAGE = "## 노선 관리 화면";
	private static final String LINE_REGISTER_MESSAGE = "1. 노선 등록";
	private static final String LINE_DELETE_MESSAGE = "2. 노선 삭제";
	private static final String LINE_PRINT_MESSAGE = "3. 노선 조회";

	private static final String SECTION_MANAGE_MESSAGE = "## 구간 관리 화면";
	private static final String SECTION_REGISTER_MESSAGE = "1. 구간 등록";
	private static final String SECTION_DELETE_MESSAGE = "2. 구간 삭제";

	private static final String SYSTEM_OUT = "Q. 종료\n";
	private static final String BACK_TO_MAIN = "B. 돌아가기\n";
	private static final String INFOMATION = "[INFO]";
	private static final String DIVIDE_INFORMATION = "---";
	private static final String SUBWAY_MAP = "## 지하철 노선도";
	public static final String SELETE_FUNCTION = "## 원하는 기능을 선택하세요.";
	
	public static final String REGISTER_STATION = "## 등록할 역 이름을 입력하세요.";
	public static final String DELETE_STATION = "## 삭제할 역 이름을 입력하세요.";
	
	public static final String REGISTER_LINE = "## 등록할 노선 이름을 입력하세요."; 
	public static final String ASCENDING_END_POINT = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
	public static final String DESCENDING_END_POINT = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
	public static final String DELETE_LINE = "## 삭제할 노선 이름을 입력하세요.";
	
	public static final String SELETE_LINE = "## 노선을 입력하세요.";
	public static final String SELETE_STATION = "## 역이름을 입력하세요.";
	public static final String REGISTER_SEQUENCE = "## 순서를 입력하세요.";
	public static final String DELETE_SECTION_LINE = "## 삭제할 구간의 노선을 입력하세요.";
	public static final String DELETE_SECTION_STATION = "## 삭제할 구간의 역을 입력하세요.";
	
	public static void printMainMenu() {
		System.out.println(MAIN_MESSAGE);
		System.out.println(MAIN_STATION_MESSAGE);
		System.out.println(MAIN_LINE_MESSAGE);
		System.out.println(MAIN_SECTION_MESSAGE);
		System.out.println(MAIN_MAP_PRINT_MESSAGE);
		System.out.println(SYSTEM_OUT);
	}
	
	public static void printStationManagementMenu() {
		System.out.println(STATION_MANAGE_MESSAGE);
		System.out.println(STATION_REGISTER_MESSAGE);
		System.out.println(STATION_DELETE_MESSAGE);
		System.out.println(STATION_PRINT_MESSAGE);
		System.out.println(BACK_TO_MAIN);
	}
	
	public static void printLineManagementMenu() {
		System.out.println(SECTION_MANAGE_MESSAGE);
		System.out.println(LINE_REGISTER_MESSAGE);
		System.out.println(LINE_DELETE_MESSAGE);
		System.out.println(LINE_PRINT_MESSAGE);
		System.out.println(BACK_TO_MAIN);
	}
	
	public static void printSectionManagementMenu() {
		System.out.println(SELETE_LINE);
		System.out.println(SECTION_REGISTER_MESSAGE);
		System.out.println(SECTION_DELETE_MESSAGE);
		System.out.println(BACK_TO_MAIN);
	}
	
}
