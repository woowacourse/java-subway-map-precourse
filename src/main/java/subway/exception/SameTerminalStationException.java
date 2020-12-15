package subway.exception;

public class SameTerminalStationException extends TerminalStationException {

    public SameTerminalStationException() {
    }

    @Override
    public String getMessage() {
        return ERROR + " 상행선 종점역과 하행선 종점역이 같습니다.";
    }
}
