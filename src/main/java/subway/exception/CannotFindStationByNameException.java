package subway.exception;

public class CannotFindStationByNameException extends RuntimeException {

    private static final String MESSAGE = "존재하지 않는 역 이름입니다. 다시 입력해주세요. 입력값: (%s)";

    public CannotFindStationByNameException(String name) {
        super(String.format(MESSAGE, name));
    }
}
