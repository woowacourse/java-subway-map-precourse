package subway.exception;

public class TooShortNameException extends IllegalArgumentException {
    private static final String MESSAGE = "%d자 이상의 이름을 입력해주시기 바랍니다.";

    public TooShortNameException(int minimumLength) {
        super(String.format(MESSAGE, minimumLength));
    }
}
