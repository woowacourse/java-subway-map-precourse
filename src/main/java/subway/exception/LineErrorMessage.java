package subway.exception;

public interface LineErrorMessage {
    /* Line */
    String ERROR_INDEX_NOT_IN_RANGE = "[ERROR] 잘못된 순서입니다.";
    String ERROR_STATION_ALREADY_ON_LINE = "[ERROR] 이미 존재하는 역입니다.";
    String ERROR_STATION_NOT_ON_LINE = "[ERROR] 노선에 해당 역이 없습니다.";
    String ERROR_STATION_NOT_ON_STATION_REPOSITORY = "[ERROR] 데이터베이스에 등록되지 않은 역입니다.";
    String ERROR_NOT_BE_ABLE_TO_DELETE_SECTION = "[ERROR] 역이 너무 적어 구간을 삭제할 수 없습니다.";
    String ERROR_INVALID_INPUT_INDEX = "\n[ERROR] 순서는 숫자를 입력해주세요!";

    /* LineRepository */
    String ERROR_INVALID_LINE_NAME_LENGTH = "[ERROR] 노선 이름이 너무 짧습니다.";
    String ERROR_DUPLICATED_LINE_NAME_IN_REPOSITORY = "[ERROR] 같은 노선 이름이 이미 있습니다.";
    String ERROR_SAME_STATION_NAME = "[ERROR] 서로 다른 이름의 역을 입력해야 합니다.";
    String ERROR_NOT_IN_STATION_REPOSITORY = "[ERROR] 기존 데이터에 없는 역이 입력됐습니다.";
    String ERROR_NOT_FOUND_LINE_NAME = "[ERROR] 해당 노선이 기존 데이터에 없습니다.";
    String EMPTY_LINE_REPOSITORY = "\n[INFO] 노선이 없습니다.";
}
