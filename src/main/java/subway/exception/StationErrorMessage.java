package subway.exception;

public interface StationErrorMessage {
    String ERROR_NO_STATION_IN_REPOSITORY = "[ERROR] 해당 역이 없습니다.";
    String ERROR_INVALID_STATION_NAME_LENGTH = "[ERROR] 역 이름이 너무 짧습니다.";
    String ERROR_DUPLICATED_STATION_NAME_IN_REPOSITORY = "[ERROR] 같은 역 이름이 이미 있습니다.";
    String ERROR_HAS_LINE = "[ERROR] 노선에 등록되어 있는 역이므로 삭제할 수 없습니다.";
    String MESSAGE_NO_STATION = "\n[INFO] 등록된 역이 존재하지 않습니다.";
}
