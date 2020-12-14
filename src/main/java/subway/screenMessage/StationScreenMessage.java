package subway.screenMessage;

public interface StationScreenMessage {
    String STATION_SCREEN_MANAGER_MENU = "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    String MESSAGE_ADD_STATION_INPUT_STATION_NAME = "\n## 등록할 역 이름을 입력하세요.";
    String MESSAGE_DELETE_STATION_INPUT_STATION_NAME = "\n## 삭제할 역 이름을 입력하세요.";
    String MESSAGE_STATION_LIST = "\n## 역 목록";
    String MESSAGE_STATION_ADDED = "\n[INFO] 지하철 역이 등록되었습니다.";
    String MESSAGE_STATION_DELETED = "\n[INFO] 지하철 역이 삭제되었습니다.";
}
