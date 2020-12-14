package subway.exception;

public class AlreadyRegisteredStationNameException extends RuntimeException {

    private static final String MESSAGE = "이미 등록된 역 이름입니다. 다시 입력해주세요. 입력값: (%s)";

    public AlreadyRegisteredStationNameException(String name) {
        super(String.format(MESSAGE, name));
    }
}
