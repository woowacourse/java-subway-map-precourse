package subway.line.exception;

public class UpstreamDownstreamStationInputException extends IllegalArgumentException {

    private static final String MESSAGE = "상행 종점역과 하행 종점역이 같을 수는 없습니다. (입력 값: '%s', '%s')";

    public UpstreamDownstreamStationInputException(final String upstreamStation,
        final String downstreamStation) {
        super(String.format(MESSAGE, upstreamStation, downstreamStation));
    }
}
