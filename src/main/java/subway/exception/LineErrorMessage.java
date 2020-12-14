package subway.exception;

public interface LineErrorMessage {
    /* Line */


    /* LineRepository */
    String ERROR_INVALID_LINE_NAME_LENGTH = "[ERROR] 노선 이름이 너무 짧습니다.";
    String ERROR_DUPLICATED_LINE_NAME_IN_REPOSITORY = "[ERROR] 같은 노선 이름이 이미 있습니다.";
    String ERROR_SAME_STATION_NAME = "[ERROR] 서로 다른 이름의 역을 입력해야 합니다.";
    String ERROR_NOT_IN_STATION_REPOSITORY = "[ERROR] 기존 데이터에 없는 역이 입력됐습니다.";
    String ERROR_NOT_FOUND_LINE_NAME = "[ERROR] 해당 노선이 기존 데이터에 없습니다.";
    String EMPTY_LINE_REPOSITORY = "\n[INFO] 노선이 없습니다.";
}
