package subway.exception;

public class DuplicatedStationInOneLineException extends RuntimeException {

    private static final String MESSAGE = "한 노선에 두 개 이상의 역은 존재할 수 없습니다. 다시 입력해주세요. 입력값: (%s)";

    public DuplicatedStationInOneLineException(String stationName) {
        super(String.format(MESSAGE, stationName));
    }
}
