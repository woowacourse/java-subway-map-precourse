package subway.exception;

public class CannotDeleteStationMoreException extends IllegalArgumentException {
    private static final String MESSAGE = "노선에 남은 역이 %d개 이하일 때는 구간을 삭제할 수 없습니다.";

    public CannotDeleteStationMoreException(int minimumStationCount) {
        super(String.format(MESSAGE, minimumStationCount));
    }
}
