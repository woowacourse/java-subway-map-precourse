package subway.exception;

public class SubwayProgramException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";
    private static final String NEWLINE = "\n";

    public SubwayProgramException(String errorMessage) {
        super(NEWLINE + PREFIX + errorMessage);
    }
}
