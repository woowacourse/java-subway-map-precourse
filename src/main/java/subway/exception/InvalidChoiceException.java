package subway.exception;

public class InvalidChoiceException extends RuntimeException {

    private static final String MESSAGE = "선택할 수 없는 기능입니다. 다시 입력해주세요. 입력값: (%s)";

    public InvalidChoiceException(String input) {
        super(String.format(MESSAGE, input));
    }
}
