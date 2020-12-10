package subway.console;

public interface SectionMessage {
    String MESSAGE_ADD_SECTION_INPUT_LINE_NAME = "## 노선을 입력하세요.";
    String MESSAGE_ADD_SECTION_INPUT_STATION_NAME = "## 역이름을 입력하세요.";
    String MESSAGE_ADD_SECTION_INPUT_STATION_INDEX = "## 순서를 입력하세요.";
    String MESSAGE_SECTION_ADDED = "[INFO] 구간이 등록되었습니다.";
    String MESSAGE_DELETE_SECTION_INPUT_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    String MESSAGE_DELETE_SECTION_INPUT_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
    String MESSAGE_SECTION_DELETED = "[INFO] 구간이 삭제되었습니다.";
}
