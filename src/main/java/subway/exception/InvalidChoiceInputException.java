package subway.exception;

public class InvalidChoiceInputException extends RuntimeException {

    private static final String MESSAGE = "잘못된 입력입니다. 다시 입력해주세요. 입력값: (%s)";

    public InvalidChoiceInputException(String input) {
        super(MESSAGE + input);
    }
}
