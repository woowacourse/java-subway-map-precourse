package subway.utils;

public interface Message {

    String DISPLAY_MAIN = "메인화면 \n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    String DISPLAY_SELECTION = "원하는 기능을 선택하세요.";
    String DISPLAY_STATION_MANAGEMENT = "역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    String DISPLAY_LINE_MANAGEMENT = "노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";
    String DISPLAY_SECTION_MANAGEMENT = "구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";
    String DISPLAY_STATION_LIST = "역 목록";
    String DISPLAY_LINE_LIST = "노선 목록";
    String DISPLAY_WHOLE_SECTION = "지하철 노선도";

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
