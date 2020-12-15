package subway.exception;

public class SectionNumberFormatException extends NumberFormatException {

    private final static String ERROR = "[ERROR]";

    @Override
    public String getMessage() {
        return ERROR + " 순서가 숫자가 아닙니다.";
    }
}
