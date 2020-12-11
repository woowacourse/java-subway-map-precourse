package subway.line;

public enum LineErrorMessage {
    ALREADY_EXISTS("중복된 이름입니다."),
    WRONG_STATION("잘못된 역입니다. 역 정보를 먼저 등록 후 이용해주세요."),
    NOT_FOUND_LINE("등록되지 않은 노선입니다."),
    INVALID_INDEX("순서가 너무 큽니다. 등록되어 있는 역 수 : %d"),
    UN_REMOVABLE("노선을 유지하려면 최소 둘 이상의 역이 등록되어 있어야 합니다."),
    WRONG_NAME("지하철 노선 이름은 %d 글자 이상이어야 합니다."),
    DUPLICATE_STATION("서로 다른 역을 입력해주세요."),
    NOT_FOUND_STATION("노선에 등록된 역이 아닙니다.")
    ;

    private String message;

    LineErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
