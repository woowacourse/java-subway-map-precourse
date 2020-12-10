package subway.line.exception;

public class CannotFindStationInLineException extends RuntimeException {

    private static final String MESSAGE = "%s 노선에 존재하지 않는 역입니다. (입력 값: '%s')";

    public CannotFindStationInLineException(final String line, String station) {
        super(String.format(MESSAGE, line, station));
    }
}
