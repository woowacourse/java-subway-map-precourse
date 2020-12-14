package subway.exception.validator;

public class NotNumberException extends ValidationException {

    public static final String NOT_NUMBER_ERROR = "숫자만 입력해주세요.";

    public NotNumberException() {
        super(NOT_NUMBER_ERROR);
    }
}
