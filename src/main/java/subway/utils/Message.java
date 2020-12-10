package subway.utils;

public interface Message {

    String ANN_REGISTER_STATION = "등록할 역 이름을 입력하세요.";
    String ANN_DELETE_STATION = "삭제할 역 이름을 입력하세요.";

    String INFO_STATION_REGISTERED = "지하철 역이 등록되었습니다.";
    String INFO_STATION_DELETED = "지하철 역이 삭제되었습니다.";

    String ERROR_NOT_REGISTERED_STATION = "등록되지 않은 역 이름입니다.";
    String ERROR_ALREADY_REGISTERED_STATION = "이미 등록된 역 이름입니다.";
    String ERROR_INVALID_STATION_NAME_LENGTH = "역 이름은 2 글자 이상이어야 합니다.";

}
