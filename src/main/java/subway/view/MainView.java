package subway.view;

public class MainView {
	private static final String MAIN_MESSAGE = "## 메인 화면";
	private static final String STATION_MESSAGE = "1. 역 관리";
	private static final String LINE_MESSAGE = "2. 노선 관리";
	private static final String SECTION_MESSAGE = "3. 구간 관리";
	private static final String SUBWAY_PRINT_MESSAGE = "4. 지하철 노선도 출력";
	private static final String SYSTEM_OUT_MESSAGE = "Q. 종료";
	private static final String SELECT_FUNCTION_MESSAGE = "\n## 원하는 기능을 선택하세요.";
	
	public static void printMainScreen() {
		System.out.println(MAIN_MESSAGE);
		System.out.println(STATION_MESSAGE);
		System.out.println(LINE_MESSAGE);
		System.out.println(SECTION_MESSAGE);
		System.out.println(SUBWAY_PRINT_MESSAGE);
		System.out.println(SYSTEM_OUT_MESSAGE);
		selectFunction();
	}
	
	public static void selectFunction() {
		System.out.println(SELECT_FUNCTION_MESSAGE);
	}

}
