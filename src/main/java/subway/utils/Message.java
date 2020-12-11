package subway.utils;

public interface Message {

    String ANN_REGISTER_STATION = "등록할 역 이름을 입력하세요.";
    String ANN_REGISTER_LINE = "등록할 노선 이름을 입력하세요.";
    String ANN_REGISTER_FIRST_STATION = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    String ANN_REGISTER_LAST_STATION = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    String ANN_DELETE_STATION = "삭제할 역 이름을 입력하세요.";
    String ANN_DELETE_LINE = "삭제할 노선 이름을 입력하세요.";
    String ANN_DELETE_SECTION_LINE = "삭제할 구간의 노선을 입력하세요";
    String ANN_DELETE_SECTION_STATION = "삭제할 구간의 역을 입력하세요";
    String ANN_SELECT_LINE = "노선을 입력하세요";
    String ANN_SELECT_STATION = "역 이름을 입력하세요";
    String ANN_INPUT_ORDER = "순서를 입력하세요";

    String INFO_STATION_REGISTERED = "지하철 역이 등록되었습니다.";
    String INFO_LINE_REGISTERED = "지하철 노선이 등록되었습니다.";
    String INFO_SECTION_REGISTERED = "구간이 등록되었습니다.";
    String INFO_STATION_DELETED = "지하철 역이 삭제되었습니다.";
    String INFO_LINE_DELETED = "지하철 노선이 삭제되었습니다.";
    String INFO_SECTION_DELETED = "구간이 삭제되었습니다.";

    String ERROR_NOT_REGISTERED_STATION = "등록되지 않은 역 이름입니다.";
    String ERROR_NOT_REGISTERED_LINE = "등록되지 않은 노선 이름입니다.";
    String ERROR_ALREADY_REGISTERED_STATION = "이미 등록된 역 이름입니다.";
    String ERROR_ALREADY_REGISTERED_LINE = "이미 등록된 노선 이름입니다.";
    String ERROR_INVALID_STATION_NAME_LENGTH = "역 이름은 2 글자 이상이어야 합니다.";
    String ERROR_INVALID_LINE_NAME_LENGTH = "노선 이름은 2 글자 이상이어야 합니다.";
    String ERROR_STATION_REGISTERED_IN_LINE = "노선에 등록된 역은 삭제할 수 없습니다.";
}
