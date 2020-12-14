package subway.util;

public class Message {
	/*
	 * title
	 */
	public static final String MAIN_VIEW = "메인 화면";
	public static final String STATION_VIEW = "역 관리 화면";
	public static final String LINE_VIEW = "노선 관리 화면";
	public static final String SECTION_VIEW = "구간 관리 화면";
	public static final String FUNCTION_CHOICE = "원하는 기능을 선택하세요.";
	
	/*
	 * sub-title
	 */
	// station
	public static final String STATION_CREATE_NAME_INPUT = "등록할 역 이름을 입력하세요.";
	public static final String STATION_REMOVE_NAME_INPUT = "삭제할 역 이름을 입하세요.";
	
	// line
	public static final String LINE_CREATE_NAME_INPUT = "등록할 노선 이름을 입력하세요.";
	public static final String LINE_REMOVE_NAME_INPUT = "삭제할 노선 이름을 입하세요.";
	public static final String LINE_UP_BOUND_TERMINUS = "등록할 노선의 상행 종점역 이름을 입력하세요.";
	public static final String LINE_DOWNSTREAM_TERMINUS = "등록할 노선의 하행 종점역 이름을 입력하세요.";
	
	// section
	public static final String SECTION_LINE = "노선을 입력하세요.";
	public static final String SECTION_STATION = "역이름을 입력하세요.";
	public static final String SECTION_SEQUENCE = "순서를 입력하세요.";
	public static final String SECTION_REMOVE_LINE = "삭제할 구간의 노선을 입력하세요.";
	public static final String SECTION_REMOVE_STATION = "삭제할 구간의 역을 입력하세요.";
	
	// subway
	public static final String SUBWAY_LINE_VIEW = "지하철 노선도";
	
	/*
	 * view
	 */
	// main
	public static final String MAIN_STATION_MANAGEMENT = "1. 역 관리";
	public static final String MAIN_LINE_MANAGEMENT = "2. 노선 관리";
	public static final String MAIN_LINE_SECTION = "3. 구간 관리";
	public static final String MAIN_SUBWAY_LINE_PRINT = "4. 지하철 노선도 출력";
	public static final String MAIN_QUITE = "Q. 종료\n";
	
	// station
	public static final String STATION_CREATE = "1. 역 등록";
	public static final String STATION_REMOVE = "2. 역 삭제";
	public static final String STATION_READ = "3. 역 조회";
	
	// line
	public static final String LINE_CREATE = "1. 노선 등록";
	public static final String LINE_REMOVE = "2. 노선 삭제";
	public static final String LINE_READ = "3. 노선 조회";
	
	// section
	public static final String SECTION_CREATE = "1. 구간 등록";
	public static final String SECTION_REMOVE = "2. 구간 삭제";
	
	// back
	public static final String BACK = "B. 돌아가기";
	
	/*
	 * info
	 */
	public static final String STATION_WAS_CREATE = "지하철 역이 등록되었습니다.";
	public static final String STATION_WAS_REMOVE = "지하철 역이 삭제되었습니다.";
	public static final String LINE_WAS_CREATE = "지하철 노선이 등록되었습니다.";
	public static final String LINE_WAS_REMOVE = "지하철 노선이 삭제되었습니다.";
	public static final String SECTION_WAS_REMOVE = "구간이 삭제되었습니다.";
	
	/*
	 * error
	 */
	public static final String WRONG_INPUT = "잘못된 입력입니다.";
	public static final String ALREADY_CREATED_STATION = "이미 등록된 역 이름입니다.";
	public static final String ALREADY_CREATED_LINE = "이미 등록된 노선 이름입니다.";
	public static final String NOT_CREATED_LINE_NAME = "등록되지 않은 노선 이름입니다.";
	public static final String NOT_CREATED_STATION_NAME = "등록되지 않은 역 이름입니다.";
	public static final String HAVE_NOT_STATION = "내에 일치하는 지하철 역 이름이 없습니다.";
	public static final String NOT_USEABLE_STATION_NAME_LENGTH = "역 이름은 2자 이상으로 구성되어야 합니다.";
	public static final String NOT_USEABLE_LINE_NAME_LENGTH = "노선 이름은 2자 이상으로 구성되어야 합니다.";
	
	/*
	 * ending
	 */
	public static final String BACK_TO_MAIN = "이전으로 돌아갑니다.";
	public static final String EXIT = "프로그램을 종료합니다.";
}
