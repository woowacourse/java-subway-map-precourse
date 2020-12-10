package subway.console;

public interface LineMessage {
    String MESSAGE_ADD_LINE_INPUT_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    String MESSAGE_LINE_ADDED = "[INFO] 지하철 노선이 등록되었습니다.";
    String MESSAGE_DELETE_LINE_INPUT_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    String MESSAGE_LINE_DELETED = "[INFO] 지하철 노선이 삭제되었습니다.";
    String MESSAGE_STATION_LIST = "## 노선 목록";
}
