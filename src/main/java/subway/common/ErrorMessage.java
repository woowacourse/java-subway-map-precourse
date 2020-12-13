package subway.common;

public class ErrorMessage extends IllegalArgumentException {
    public static final String OUT = "OUT";
    private static final String ERROR_PREFIX = "\n[ERROR] ";

    public ErrorMessage(String message) {
        super(ERROR_PREFIX+message);
    }

}
