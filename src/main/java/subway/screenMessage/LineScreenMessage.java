package subway.screenMessage;

public interface LineScreenMessage {
    String MENU = "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";
    String MESSAGE_INPUT_LINE_NAME_TO_ADD = "\n## 등록할 노선 이름을 입력하세요.";
    String MESSAGE_INPUT_UP_END_STATION_OF_LINE_TO_ADD = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    String MESSAGE_INPUT_DOWN_END_STATION_OF_LINE_TO_ADD = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    String MESSAGE_LINE_ADDED = "\n[INFO] 지하철 노선이 등록되었습니다.";
    String MESSAGE_INPUT_LINE_NAME_TO_DELETE = "\n## 삭제할 노선 이름을 입력하세요.";
    String MESSAGE_LINE_DELETED = "\n[INFO] 지하철 노선이 삭제되었습니다.";
    String MESSAGE_STATION_LIST = "\n## 노선 목록";
    String[] MENU_CHOICES = {"1", "2", "3", "B"};
    String ADD = MENU_CHOICES[0];
    String DELETE = MENU_CHOICES[1];
    String DISPLAY = MENU_CHOICES[2];
    String BACK = MENU_CHOICES[3];
}
