package subway.Exception;

public class SubwayRelatedException extends IllegalArgumentException{
    public static final String ERROR_TAG = "[ERROR]";

    public SubwayRelatedException(String message) {
        super(ERROR_TAG + message);
    }
}
