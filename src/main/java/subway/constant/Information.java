package subway.constant;

public class Information {

    public static final String INFO_HEADER = "\n[INFO] ";

    public static final String CHOOSE_FUNCTION = "\n## 원하는 기능을 선택하세요.";
    public static final String MAIN_INFO = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n" + CHOOSE_FUNCTION;

    public static final String STATION_INFO = "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n" + CHOOSE_FUNCTION;
    public static final String ADD_STATION_INFO = "\n## 등록할 역 이름을 입력하세요.";
    public static final String ADD_STATION_SUCCESS = INFO_HEADER + "지하철 역이 등록되었습니다.";
    public static final String DELETE_STATION_INFO = "\n## 삭제할 역 이름을 입력하세요.";
    public static final String DELETE_STATION_SUCCESS = INFO_HEADER + "지하철 역이 삭제되었습니다.";
    public static final String SHOW_STATION_INFO = "\n## 역 목록";

    public static final String LINE_INFO = "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n" + CHOOSE_FUNCTION;

    public static final String AREA_INFO = "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기\n" + CHOOSE_FUNCTION;

    public static final String MAP_INFO = "\n## 지하철 노선도";
}
