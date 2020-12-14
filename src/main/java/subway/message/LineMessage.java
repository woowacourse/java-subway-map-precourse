package subway.message;

public interface LineMessage {
    String MESSAGE_INPUT_LINE_NAME_TO_ADD = "\n## 등록할 노선 이름을 입력하세요.";
    String MESSAGE_INPUT_UP_END_STATION_OF_LINE_TO_ADD = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    String MESSAGE_INPUT_DOWN_END_STATION_OF_LINE_TO_ADD = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    String MESSAGE_LINE_ADDED = "\n[INFO] 지하철 노선이 등록되었습니다.";
    String MESSAGE_INPUT_LINE_NAME_TO_DELETE = "\n## 삭제할 노선 이름을 입력하세요.";
    String MESSAGE_LINE_DELETED = "\n[INFO] 지하철 노선이 삭제되었습니다.";
    String MESSAGE_LINE_LIST = "\n## 노선 목록";
}
