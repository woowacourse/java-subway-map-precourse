package subway.message;


public enum ErrorMessage {
    NOT_SELECTABLE_ERROR("[ERROR] 선택할 수 없는 기능입니다."),

    ;

    private final String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return this.error;
    }
}
