package subway.io;

public enum Error {
    INVALID_COMMAND("선택할 수 없는 기능입니다.");

    private static final String ERROR_FORMAT = "\n[ERROR] %s";

    private final String message;

    Error(String message) {
        this.message = String.format(ERROR_FORMAT, message);
    }

    public String toString() {
        return message;
    }
}
