package subway.station.exception;

public class CanNotRemoveIfRegisteredException extends RuntimeException {
    private static final String MESSAGE = "노선에 등록된 역은 삭제할 수 없습니다.";

    public CanNotRemoveIfRegisteredException() {
        super(MESSAGE);
    }
}
