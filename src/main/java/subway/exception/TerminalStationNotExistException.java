package subway.exception;

public class TerminalStationNotExistException extends TerminalStationException {

    public TerminalStationNotExistException() {
    }

    @Override
    public String getMessage() {
        return ERROR + " 상행선 종점역 또는 하행선 종점역이 존재하지 않는 역입니다.";
    }
}
