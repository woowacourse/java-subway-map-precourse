package subway.util;

public class Message {
	
	// title
	public static final String MAIN_VIEW = "메인 화면";
	public static final String STATION_VIEW = "역 관리 화면";
	public static final String LINE_VIEW = "노선 관리 화면";
	public static final String SECTION_VIEW = "구간 관리 화면";
	public static final String FUNCTION_CHOICE = "원하는 기능을 선택하세요.";
	
	// sub-title station
	public static final String STATION_CREATE_NAME_INPUT = "등록할 역 이름을 입력하세요.";
	public static final String STATION_REMOVE_NAME_INPUT = "삭제할 역 이름을 입하세요.";
	
	// sub-title line
	public static final String LINE_CREATE_NAME_INPUT = "등록할 노선 이름을 입력하세요.";
	public static final String LINE_REMOVE_NAME_INPUT = "삭제할 노선 이름을 입하세요.";
	public static final String LINE_UP_BOUND_TERMINUS = "등록할 노선의 상행 종점역 이름을 입력하세요.";
	public static final String LINE_DOWNSTREAM_TERMINUS = "등록할 노선의 하행 종점역 이름을 입력하세요.";
	
	// sub-title section
	public static final String SECTION_LINE = "노선을 입력하세요.";
	public static final String SECTION_STATION = "역이름을 입력하세요.";
	public static final String SECTION_SEQUENCE = "순서를 입력하세요.";
	public static final String SECTION_REMOVE_LINE = "삭제할 구간의 노선을 입력하세요.";
	public static final String SECTION_REMOVE_STATION = "삭제할 구간의 역을 입력하세요.";
	
	// main-view
	public static final String MAIN_STATION_MANAGEMENT = "1. 역 관리";
	public static final String MAIN_LINE_MANAGEMENT = "2. 노선 관리";
	public static final String MAIN_LINE_SECTION = "3. 구간 관리";
	public static final String MAIN_SUBWAY_LINE_PRINT = "4. 지하철 노선도 출력";
	public static final String MAIN_QUITE = "Q. 종료\n";
	
	// station-view
	public static final String STATION_CREATE = "1. 역 등록";
	public static final String STATION_REMOVE = "2. 역 삭제";
	public static final String STATION_READ = "3. 역 조회";
	
	// line-view
	public static final String LINE_CREATE = "1. 노선 등록";
	public static final String LINE_REMOVE = "2. 노선 삭제";
	public static final String LINE_READ = "3. 노선 조회";
	
	// section-view
	public static final String SECTION_CREATE = "1. 구간 등록";
	public static final String SECTION_REMOVE = "2. 구간 삭제";
	
	public static final String BACK = "B. 돌아가기";
}
